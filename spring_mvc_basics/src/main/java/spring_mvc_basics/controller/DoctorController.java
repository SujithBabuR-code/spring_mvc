package spring_mvc_basics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Dao.DoctorDao;

@Controller
public class DoctorController {
	@Autowired
	DoctorDao dao;

	@ResponseBody
	@RequestMapping("/insert")
	public void insert(@ModelAttribute DoctorDto d1) {
//		System.out.println(d1.getId());
//		System.out.println(d1.getName());
		dao.insert(d1);
	}

	@ResponseBody
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boolean r = dao.delete(id);
		if (r == true)
			return "data deleted";
		else
			return "data not found so not deleted";
	}

	@ResponseBody
	@RequestMapping("/deleteall")
	public String deleteAll() {
		String ans = dao.deleteAll();
		return ans;
	}

	@ResponseBody
	@RequestMapping("/findbyid")
	public DoctorDto findById(@RequestParam int id) {
		DoctorDto d1 = dao.findById(id);
		System.out.println(d1);
		return d1;
	}

	@ResponseBody
	@RequestMapping("/fetchall")
	public ModelAndView fetchall() {
		List<DoctorDto> d = dao.fetchAll();
//		if(d==null)
//		{
//			System.out.println("no data found");
//		}
//		else
//		{
//			for(DoctorDto uv:d)
//			{
//				System.out.println(uv);
//			}
//		}
		ModelAndView view = new ModelAndView("download.jsp");
		view.addObject("objects", d);
		return view;

	}
	@ResponseBody
	@RequestMapping("/ud")
	public RedirectView updateAll(@ModelAttribute DoctorDto d2) {
//		System.out.println(d2.getId());
//		System.out.println(d2.getName());
		dao.updateAll(d2);
		return  new RedirectView("fetchall");
		
	}
}
