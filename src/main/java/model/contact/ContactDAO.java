package model.contact;

import model.Contact;

import java.util.List;

/**
 * Created by luhaiming on 2017/2/4 0004.
 */
public interface ContactDAO {
    public void saveOrUpdate(Contact contact);

    public void delete(int contactId);

    public Contact get(int contactId);

    public List<Contact> list();
}
