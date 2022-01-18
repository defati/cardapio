package com.fours.cardapio.resources;
/*
 * package com.fours.cardapio.resource;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RequestPart; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.cardapio.entities.Pessoa; import
 * com.fours.cardapio.repository.PessoaRepository; import
 * com.fours.cardapio.service.PessoaService;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/pessoa") public class PessoaResource {
 * 
 * //configurar o spring boot no application.properties para multi part
 * 
 * @Autowired PessoaService pessoaService;
 * 
 * @Autowired PessoaRepository pessoaRepository;
 * 
 * @PostMapping("/salvar") public ResponseEntity<?> salvar(@RequestPart Pessoa
 * pessoa, @RequestParam("file") MultipartFile file) {
 * 
 * //TRABALHAR COM O USUÁRIO //salva pessoa no DB e retorna a entidade que foi
 * salva... já com seu ID pessoaRepository.saveAndFlush(pessoa);
 * 
 * //SAÍDA NO CONSOLE PARA TESTE System.out.println(pessoa.getId()); //PASTA
 * ONDE VÃO SER SALVOS TODOS OS ARQUIVOS //String pastaCaminho =
 * "C:/Users/Eduardo/Pictures/uploadAPI/";
 * 
 * //TRABALHAR COM O ARQUIVO
 * 
 * try { if(!file.isEmpty()) { //dissolve o arquivo em bytes byte[]
 * arquivoEmBytes = file.getBytes();
 * 
 * //monta a url do arquivo (nome do arquivo) //String urlCaminho = pastaCaminho
 * + String.valueOf(pessoa.getId()) + file.getOriginalFilename();
 * 
 * //monta o caminho onde o arquivo vai ser escrito (salvo) //Path caminho =
 * Paths.get(urlCaminho);
 * 
 * //Escreve os bytes do arquivo no caminho especificado //Files.write(caminho,
 * arquivoEmBytes);
 * 
 * //copia o arquivo para o PATH de destino e se existir o arquivo substiui o
 * arquivo existente //Files.copy(file, caminho,
 * StandardCopyOption.REPLACE_EXISTING);
 * 
 * //SETAR O CAMINHO DO ARQUIVO NO USUÁRIO
 * //pessoa.setCaminhoArquivo(pastaCaminho + String.valueOf(pessoa.getId()) +
 * file.getOriginalFilename()); //pessoa.setCaminhoArquivo(urlCaminho);
 * 
 * } } catch (IOException e) { throw new
 * RuntimeException("Problemas na tentativa de salvar arquivo"); }
 * 
 * 
 * 
 * //try { //cria diretorio //Files.createDirectories(diretorio);
 * 
 * 
 * try { file.transferTo( new File(caminho)); } catch (IllegalStateException e){
 * e.printStackTrace(); } catch (IOException e) { e.getMessage(); }
 * 
 * //chamar o service de upload de arquivo
 * 
 * return ResponseEntity.status(201).body("Tudo salvo com sucesso"); }
 * 
 * @GetMapping("/listar") public ResponseEntity<List<Pessoa>> listar(){ return
 * pessoaService.lista(); }
 * 
 * @GetMapping("/{id}") public ResponseEntity<Optional<Pessoa>>
 * buscarPorId(@PathVariable("id") Long id){ return
 * pessoaService.buscaPorId(id); }
 * 
 * @GetMapping("/pesquisar/{pesquisa}") public ResponseEntity<List<Pessoa>>
 * pesquisar(@PathVariable("pesquisa") String pesquisa){ return
 * pessoaService.pesquisa(pesquisa); }
 * 
 * @PutMapping("/editar") public ResponseEntity<String> editar(@RequestBody
 * Pessoa pessoa){ return pessoaService.edita(pessoa); }
 * 
 * @DeleteMapping("/{id}") public ResponseEntity<String>
 * deletar(@PathVariable("id") Long id){ return pessoaService.deleta(id); }
 * 
 * }
 */