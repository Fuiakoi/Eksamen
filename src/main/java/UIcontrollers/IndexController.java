package UIcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@GetMapping ("/find")
	public String find(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "find";
	}

	@PostMapping("/find")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// UseCase uc = new UseCase();
		// String res = uc.loginCheck(username, password);
		String res = "Hej";
		model.addAttribute("answer", res);
		return "sofia";
	}

	@GetMapping ("/start")
	public String start(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "start";
	}

	@PostMapping("/start")
	public String start(@RequestParam String username, @RequestParam String password, Model model) {
		// UseCase uc = new UseCase();
		// String res = uc.loginCheck(username, password);
		String res = "Hej";
		model.addAttribute("answer", res);
		return "sofia";
	}
}