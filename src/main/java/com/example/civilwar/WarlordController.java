package com.example.civilwar;

import java.util.List;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.civilwar.Warlord;
//import com.example.civilwar.WarlordRepository;

@Controller
@RequestMapping("/html")
public class WarlordController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//	private WarlordRepository warlordRepository;

	@ModelAttribute
	WarlordForm userForm() {
		return new WarlordForm();
	}

	public String test(String name) { // ②メソッドの引数にModel型の値を設定するとModelのインスタンスが自動的に渡される
		List<Warlord> list = jdbcTemplate.queryForObject("select text from date where name = ?", new Object[] { name },
				new WarlordService());
		String st = null;
		for (Warlord text : list) {
			text.setText("");
			st = text.getText();
		}
		return st;
	}

	@GetMapping
	public String index(Model model) { // ②メソッドの引数にModel型の値を設定するとModelのインスタンスが自動的に渡される

		return "html/index"; // ④returnしている文字列を元に、src/main/resources/templates/配下からファイルを見つけてユーザに返している
	}

	@GetMapping("new")
	public String newWorload(Model model) {
		// n新規作成画面に対してWarlordインスタンスを渡すようにする
		// nこれがないと入力エラー時に入力していた内容を保持することができない
		Warlord warlord = new Warlord();
		model.addAttribute("warlord", warlord);
		return "html/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) { // メソッドの引数に@PathVariableを設定するとURL上の値を取得することができる
//		Warlord warlord = warlordService.findOne(id);
		List<Warlord> html = jdbcTemplate.queryForObject("select * from date where id = ? ", new Object[] { id },
				new WarlordService());
		model.addAttribute("html", html);
		return "html/edit";
	}

	@GetMapping("show")
	public String show(Model model) {
		List<Warlord> html = jdbcTemplate.queryForObject("select * from date where num = 1", new WarlordService());
		model.addAttribute("html", html); // ③ ②で受け取ったmodelに値を詰めることで、テンプレートに値を渡すことができる
		return "html/show"; // ④returnしている文字列を元に、src/main/resources/templates/配下からファイルを見つけてユーザに返している
	}

	@GetMapping("diagnosis")
	public String diagnosis(Model model) {
		Lordtext lordtext = new Lordtext();
		Lordtext lordtext2 = new Lordtext();
		Lordtext lordtext3 = new Lordtext();
		lordtext.putRadio();
		lordtext2.putRadio2();
		lordtext3.putRadio3();

		model.addAttribute("radioItems", lordtext.getRadio());
		model.addAttribute("radioItems2", lordtext2.getRadio2());
		model.addAttribute("radioItems3", lordtext3.getRadio3());
		Lord lordRadio = new Lord();
		model.addAttribute("lordRadio", lordRadio);
		return "html/diagnosis";
	}

	@PostMapping("radio")
	public String diagnosis2(@ModelAttribute Lord lordRadio, Model model) {
		int i = Integer.parseInt(lordRadio.getSelectedRadio());
		int i2 = Integer.parseInt(lordRadio.getSelectedRadio2());
		int i3 = Integer.parseInt(lordRadio.getSelectedRadio3());

		Lordsort lordsort = new Lordsort();
		lordsort.sort(i, i2, i3);
		String lord = lordsort.lord();
		String lt = lordsort.lt();
		model.addAttribute("lord", lord);
		model.addAttribute("lt", lt);
		return "html/result";
	}

	@PostMapping
	public @ResponseBody ModelAndView create(Model model, @ModelAttribute WarlordForm warlordForm) {
		jdbcTemplate.update("INSERT INTO date (name,text) values (?,?)", warlordForm.getName(), warlordForm.getText());
//		if (bindingResult.hasErrors())
//			return "html/new"; // エラーがあるとbindingResult.hasErrors()がtrueを返すのでその場合はもとの画面に返している
//		warlordRepository.save(warlord);
		List<Warlord> html = jdbcTemplate.queryForObject("select * from date where num = 1", new WarlordService());
		ModelAndView mv = new ModelAndView();
		mv.addObject("html", html);
		mv.setViewName("html/show");
		return mv; // "redirect:/players"とすると/playersにリダイレクトされる
	}

//
	@PostMapping("{id}")
	public String update(Model model, @ModelAttribute WarlordForm warlordForm) {
		jdbcTemplate.update("UPDATE date SET name = ?,text = ? where id = ? ", warlordForm.getName(),
				warlordForm.getText(), warlordForm.getId());
		return "redirect:/html/show";
	}

	@DeleteMapping("{id}")
	public String destroy(Model model, @PathVariable("id") int id) {
		jdbcTemplate.update("UPDATE date SET num = 0 where id = ? ", id);
		return "redirect:/html/show";
	}

}
