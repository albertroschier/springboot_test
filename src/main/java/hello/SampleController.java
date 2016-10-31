package hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.service.HenkiloService;
import hello.service.JuttuService;
import hello.service.JuttuServiceImpl;

@Controller
public class SampleController {

	@Autowired
	private HenkiloService henkiloService;
	@Autowired
	private JuttuService juttuService;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/asd/{someID}")
	public @ResponseBody String getAttrbyregex(@PathVariable(value = "someID") String id) {
		return id;
	}

	@GetMapping("/hello")
	public String getHello(Map<String, Object> model) {
		model.put("example", "");
		model.put("henkilo", henkiloService.listHenkilos());
		model.put("juttu", juttuService.listJuttus());
		return "hello";
	}
	
	@PostMapping("/hello")
	public String henkiloSubmit(@ModelAttribute Henkilo henkilo) {
		henkiloService.insertHenkilo(henkilo);
		return "redirect:hello";
	}
	
	@PostMapping("/update")
	public String henkiloUpdate(@ModelAttribute Henkilo henkilo) {
		System.out.println(henkilo.getEtunimi() + " " + henkilo.getSukunimi());
		henkiloService.updateHenkilo(henkilo);
		return "redirect:hello";
	}
	
	@GetMapping("/update")
	public String getUpdate(Map<String, Object> model, @RequestParam Integer henkiloid) {
		model.put("henkilo", henkiloService.getHenkilo(henkiloid));
		return "update";
	}
	
	@GetMapping("/delete")
	public String henkiloDelete(@ModelAttribute Henkilo henkilo) {
		henkiloService.deleteHenkilo(henkilo);
		return "redirect:hello";
	}
	
}