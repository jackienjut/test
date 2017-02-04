package controller;

/**
 * Created by luhaiming on 2017/2/4 0004.
 */
public class HomeController {
    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value="/")
    public ModelAndView listContact(ModelAndView model) throws IOException{
        List<Contact> listContact = contactDAO.list();
        model.addObject("listContact", listContact);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value="/")
    public ModelAndView listContact(ModelAndView model) throws IOException{
        List<Contact> listContact = contactDAO.list();
        model.addObject("listContact", listContact);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contact", contact);

        return model;
    }
}
