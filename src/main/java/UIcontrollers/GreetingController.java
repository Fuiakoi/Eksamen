package UIcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/form")
	public String form(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "formside";
	}

	@PostMapping("/form")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// UseCase uc = new UseCase();
		// String res = uc.loginCheck(username, password);
		String res = "Hej";
		model.addAttribute("answer", res);
		return "formsideres";
	}
}
