package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.DishModel;
import com.softserve.academy.food.service.IMenuService;
import com.softserve.academy.food.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private IOrderService orderService;
    
	@Autowired
	private IMenuService dishService;

//TODO
    @RequestMapping(value = "/order{id}", method = RequestMethod.GET)
    public String add( @PathVariable int id, HttpSession session ) {
    	
    	float sum=0;
    	
		if ( session.getAttribute("baskedlist")!=null )
		{
			Map<Integer,Integer> baskedlist  = (HashMap<Integer,Integer>)session.getAttribute("baskedlist");
			
			sum = (Float)session.getAttribute("baskedsum");
			sum+=dishService.getDish(id).getPrice();
			session.setAttribute( "baskedsum", sum );
			
			if (baskedlist.containsKey(id))
			{
				baskedlist.put(id, baskedlist.get(id)+1);
			}
			else
			{
				baskedlist.put(id, 1);
			}
		}
		else
		{
			session.setAttribute( "baskedlist", new HashMap<Integer,Integer>() );
			session.setAttribute( "baskedsum", new Float(0) );
			session.setAttribute( "baskedqunti", new Integer(0) );
		}
    	
        return "menu";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, Model model, HttpSession session) {
    	
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(name));
        //TODO
//        orderService.add(1, list);
        return "redirect:../order";
    }

}
