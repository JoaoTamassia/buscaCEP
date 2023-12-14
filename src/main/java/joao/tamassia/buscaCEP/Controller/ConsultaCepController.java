package joao.tamassia.buscaCEP.Controller;

import joao.tamassia.buscaCEP.entities.formatoCEP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
