package joao.tamassia.buscaCEP.Controller;

import joao.tamassia.buscaCEP.entities.formatoCEP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/consultaCEP")
public class ConsultaCepController {

    @GetMapping("{cep}")
    public formatoCEP ConsultaCep(@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<formatoCEP> resp =
                restTemplate
                        .getForEntity("https://viacep.com.br/ws/"+cep+"/json/", formatoCEP.class);
        return resp.getBody();
    }
//    @GetMapping("/porEndereco")
//    public List<formatoCEP> ConsultaCepPorEndereco(
//            @RequestParam("uf") String uf,
//            @RequestParam("localidade") String localidade,
//            @RequestParam("logradouro") String logradouro) {
//
//        String url = String.format("https://viacep.com.br/ws/%s/%s/%s/json/", uf, localidade, logradouro);
//
//        RestTemplate restTemplate = new RestTemplate();
//        formatoCEP[] listaEnderecos = restTemplate.getForObject(url, formatoCEP[].class);
//
//        return listaEnderecos != null ? Arrays.asList(listaEnderecos) : Collections.emptyList();
//    }
@GetMapping("/porEndereco")
public List<formatoCEP> ConsultaCepPorEndereco() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe a UF: ");
    String uf = scanner.nextLine();

    System.out.print("Informe a localidade: ");
    String localidade = scanner.nextLine();

    System.out.print("Informe o logradouro: ");
    String logradouro = scanner.nextLine();

    String url = String.format("https://viacep.com.br/ws/%s/%s/%s/json/", uf, localidade, logradouro);

    RestTemplate restTemplate = new RestTemplate();
    formatoCEP[] listaEnderecos = restTemplate.getForObject(url, formatoCEP[].class);

    List<formatoCEP> resultado = listaEnderecos != null ? Arrays.asList(listaEnderecos) : Collections.emptyList();

    // Imprimir os resultados no console
    for (formatoCEP endereco : resultado) {
        System.out.println(endereco);
    }

    return resultado;
}
}
