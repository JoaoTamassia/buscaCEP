package joao.tamassia.buscaCEP;

import joao.tamassia.buscaCEP.entities.formatoCEP;
import joao.tamassia.buscaCEP.Controller.ConsultaCepController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BuscaCepApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BuscaCepApplication.class, args);

		// Obter uma instância do ConsultaCepController
		ConsultaCepController cepController = context.getBean(ConsultaCepController.class);

		// Chamar a função ConsultaCepPorEndereco
		cepController.ConsultaCepPorEndereco();

		// Fechar o contexto da aplicação
		context.close();
	}

}