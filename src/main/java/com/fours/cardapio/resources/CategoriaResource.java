package com.fours.cardapio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fours.cardapio.entities.Categoria;
import com.fours.cardapio.services.CategoriaService;
import com.fours.cardapio.upload.ArquivoService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	ArquivoService arquivoService;

	// pasta onde vao ser salvos todos os diretorios e seus arquivos
	String caminhoGeral = "C:/Users/Eduardo/Pictures/img/categorias/";

	// SALVA e ATUALIZA
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestPart Categoria categoria, @RequestParam("file") MultipartFile file) {

		// salva usuario no DB e retorna a entidade que foi salva, já com seu ID
		categoriaService.salvaRetornaId(categoria);

		// para manter o caminho do arquivo no DB, o front-end deverá mandar o caminho
		// que pegou no DB para mantê-lo

		// TRABALHAR COM O UPLOAD DO ARQUIVO
		if (!file.isEmpty()) {

			// chama a função de upload dos arquivos
			String urlArquivo = arquivoService.salvaArquivo(file, categoria.getId(), caminhoGeral);

			// setar o caminho do arquivo no usuario
			categoria.setImg(urlArquivo);
		}

		// atualizar o usuario com o caminho do arquivo
		categoriaService.salva(categoria);

		return ResponseEntity.status(201).body("Tudo salvo com sucesso");
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Categoria>> listar() {
		return categoriaService.lista();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable("id") Long id) {
		return categoriaService.buscaPorId(id);
	}

	@GetMapping("/pesquisar/{pesquisa}")
	public ResponseEntity<List<Categoria>> pesquisar(@PathVariable("pesquisa") String pesquisa) {
		return categoriaService.pesquisa(pesquisa);
	}

	@PutMapping("/editar")
	public ResponseEntity<String> editar(@RequestBody Categoria categoria) {
		return categoriaService.edita(categoria);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
		// deletar usuario no DB e todos os arquivos e subdiretórios ligados a este usuário
		String diretorio = caminhoGeral + id;
		arquivoService.deletarArquivo(diretorio);
		return categoriaService.deleta(id);
	}

}
