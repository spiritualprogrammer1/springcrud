package crudsprings.demo.web;

import crudsprings.demo.DAO.ProductRepository;
import crudsprings.demo.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String listeprodui(Model model, @RequestParam(name="page", defaultValue ="0") int page,
                              @RequestParam(name="motClef", defaultValue ="0") String mc  )
    {
        List<Produit> produits;

      Page<Produit> pageProduits = productRepository.findAll(PageRequest.of(page,5));
//        produits = productRepository.findAll();

        model.addAttribute("listeproduit",pageProduits.getContent());
        model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("motCle",mc);

        return "produit";
    }

    @GetMapping("/delete")
    public String delete(Long id)
    {
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/formProduit")
    public String form(Model model)
    {
        /**********on creer un formulaire de type produit en inserant le produit*******/
        model.addAttribute("produit",new Produit());
        return "formProduit";
    }

    @GetMapping("/edit")
    public String form(Model model,Long id)
    {
        Produit produit = productRepository.findById(id).get();
        model.addAttribute("produit",produit);
        return "editProduit";
    }

    @PostMapping("/save")
    public String save(Model model,@Valid Produit produit, BindingResult bindingResult)
    {
     if(bindingResult.hasErrors()) return "formProduit";
        productRepository.save(produit);
        return "redirect:/index";
    }


}
