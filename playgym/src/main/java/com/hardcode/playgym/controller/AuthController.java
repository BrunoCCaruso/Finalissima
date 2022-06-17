package com.hardcode.playgym.controller;


import com.hardcode.playgym.entity.Asesor;
import com.hardcode.playgym.entity.User;
import com.hardcode.playgym.service.AsesorService;
import com.hardcode.playgym.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AsesorService asesorService;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Principal principal) {
        ModelAndView mav = new ModelAndView("indexCristian");

        if (error != null) mav.addObject("error", "Invalid email or password");
        if (logout != null) mav.addObject("logout", "You have successfully exited the platform");
        if (principal != null) mav.setViewName("redirect:/");

        return mav;
    }

    @GetMapping("/registro-roles")
    public ModelAndView registroRoles(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Principal principal) {
        ModelAndView mav = new ModelAndView("registro_roles_alex");

        if (error != null) mav.addObject("error", "Invalid email or password");
        if (logout != null) mav.addObject("logout", "You have successfully exited the platform");
        if (principal != null) mav.setViewName("redirect:/");

        return mav;
    }

    @GetMapping("/sign-up/asesor")
    public ModelAndView signup(HttpServletRequest request, Principal principal) {
        ModelAndView mav = new ModelAndView("registro-asesor");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (principal != null) mav.setViewName("redirect:/");

        if (inputFlashMap != null) {
            mav.addObject("exception", inputFlashMap.get("exception"));
            mav.addObject("user", inputFlashMap.get("user"));
        } else {
            User user = new User();
            user.setRole("ASESOR");
            mav.addObject("user", user);
        }

        return mav;
    }

    @GetMapping("/sign-up/cliente")
    public ModelAndView signupCliente(HttpServletRequest request, Principal principal) {
        ModelAndView mav = new ModelAndView("registro-usuario");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (principal != null) mav.setViewName("redirect:/");

        if (inputFlashMap != null) {
            mav.addObject("exception", inputFlashMap.get("exception"));
            mav.addObject("user", inputFlashMap.get("user"));
        } else {
            User user = new User();
            user.setRole("CLIENTE");
            mav.addObject("user", user);
        }

        return mav;
    }

    @GetMapping("/info-asesor")
    public ModelAndView infoAsesor(HttpServletRequest request, Principal principal) {
        ModelAndView mav = new ModelAndView("registro-info-asesor");
        mav.addObject("asesor", new Asesor());
        return mav;
    }



    @PostMapping("/register/asesor")
    public RedirectView signupAsesor(User userDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/auth/info-asesor");

        try {
            userService.create(userDto);
        } catch (IllegalArgumentException e ) {
            attributes.addFlashAttribute("user", userDto);
            attributes.addFlashAttribute("exception", e.getMessage());
            redirect.setUrl("/auth/sign-up");
        }

        return redirect;
    }

    @GetMapping("/mi-perfil-asesor")
    public ModelAndView miPerfilAsesor(HttpServletRequest request, Principal principal) {
        ModelAndView mav = new ModelAndView("mi-perfil-asesor");
        return mav;
    }



    @PostMapping("/register/asesor-info")
    public RedirectView signupAsesor(Asesor asesorDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/auth/mi-perfil-asesor");

        try {
            asesorService.create(asesorDto);
        } catch (IllegalArgumentException e ) {
            attributes.addFlashAttribute("user", asesorDto);
            attributes.addFlashAttribute("exception", e.getMessage());
            redirect.setUrl("/auth/sign-up");
        }

        return redirect;
    }







    @PostMapping("/register/cliente")
    public RedirectView signupUsuario(User userDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/");

        try {
            userService.create(userDto);
        } catch (IllegalArgumentException e ) {
            attributes.addFlashAttribute("user", userDto);
            attributes.addFlashAttribute("exception", e.getMessage());
            redirect.setUrl("/auth/sign-up");
        }

        return redirect;
    }
}
