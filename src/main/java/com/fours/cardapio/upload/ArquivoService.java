package com.fours.cardapio.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoService {

	// TRABALHAR COM O ARQUIVO
	public String salvaArquivo(MultipartFile file, Long id, String caminhoGeral) {

		try {
			verificaDiretorio(caminhoGeral);
			// criar um diretorio para cada arquivo
			File diretorio = new File(caminhoGeral + id);
			diretorio.mkdir();

			// dissolve o arquivo em bytes
			byte[] imgEmBytes = file.getBytes();

			// chama o método para redimensionar a imagem
			byte[] imgPronta = redimensionaImagem(imgEmBytes);

			// pegar a extensao do arquivo com APACHE commons IO
			String extensaoDoArquivo = FilenameUtils.getExtension(file.getOriginalFilename());

			// verifica se o arquivo possui as extensões jpg, jpeg ou png
			// deixar fazer upload somente extensões jpg, jpeg, png
			if (!extensaoDoArquivo.equalsIgnoreCase("jpg") && !extensaoDoArquivo.equalsIgnoreCase("jpeg")
					&& !extensaoDoArquivo.equalsIgnoreCase("png")) {
				throw new FilerException("Somente imagens do tipo JPG, JPEG ou PNG são permitidas");
			}

			// montar a url do arquivo
			String urlArquivo = diretorio + "/" + id + "." + "jpg";

			// montar o caminho onde o arquivo vai ser escrito(salvo)
			Path caminho = Paths.get(urlArquivo);

			// escrever os bytes do arquivo no caminho especificado
			Files.write(caminho, imgPronta);

			return urlArquivo;

		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar o arquivo");
		}

	}

	// VERIFICA DIRETORIO
	// verificar se existe este diretorio
	// se não existir, criar o diretório e passar na variável caminhoGeral
	// se existir só passar na variável
	public String verificaDiretorio(String caminhoGeral) {
		File pasta = new File(caminhoGeral);
		if (!pasta.exists()) {
			pasta.mkdirs();
		}
		return caminhoGeral;
	}
	
	// REDIMENSIONA IMAGEM
	/*
	 * recebe um array de Bytes pega o array de Bytes e transforma em BufferedImage
	 * aplica o redimensionador de imagens e transforma a BufferedImage em array de
	 * Bytes
	 */
	public static byte[] redimensionaImagem(byte[] imgEmBytes) {

		// converte byte[] em BufferedImage
		BufferedImage bi = null;

		try {
			bi = ImageIO.read(new ByteArrayInputStream(imgEmBytes));
		} catch (IOException e) {
			e.getMessage();
		}

		// aplica o redimensionador de imagem - Dependência do ImgScalr
		BufferedImage biRedimensionada = Scalr.resize(bi, 250);

		// converte BufferedImage em byte[]
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(biRedimensionada, "jpg", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] imgPronta = baos.toByteArray();

		return imgPronta;
	}

	// DELETAR DIRETORIOS E ARQUIVOS
	// deleta todos os arquivos e subdiretórios
	public void deletarArquivo(String diretorio) {
		File dir = new File(diretorio);
		if (dir.isDirectory() && dir.exists()) {
			try {
				FileUtils.deleteDirectory(dir);
			} catch (IOException e) {
				throw new RuntimeException("Problemas na tentativa de deletar o diretório: " + dir);
			}
		}
	}
}
