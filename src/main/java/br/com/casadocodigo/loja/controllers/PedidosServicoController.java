package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Pedido;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarPedidos(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model){
		String uri = "https://book-payment.herokuapp.com/orders";
		
		try {
			Pedido[] response = restTemplate.getForObject(uri, Pedido[].class);
			model.addFlashAttribute("message", response);
			System.out.println(response);
			
			ModelAndView modelAndView = new ModelAndView("carrinho/pedidos");
			modelAndView.addObject("response", response);
									
			return modelAndView;
			
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			model.addFlashAttribute("message", "Lista de pedidos não carregada");
			return new ModelAndView("redirect:/pedidos");
		}
	}

}