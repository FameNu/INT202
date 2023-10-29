package sit.int202.newinclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.newinclass.entities.Office;

public class testJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class, "8");
        if (office != null) {
            System.out.printf("%s %s %s%n",
                    office.getCity(),
                    office.getCountry(),
                    office.getPostalCode());
        } else System.out.println("Specify office code does not exist !!!");
        Office newOffice = new Office();
        newOffice.setOfficeCode("8");
        newOffice.setAddressLine1(office.getAddressLine1());
        newOffice.setAddressLine2(office.getAddressLine2());
        newOffice.setCity(office.getCity());
        newOffice.setPhone(office.getPhone());
        newOffice.setPostalCode(office.getPostalCode());
        newOffice.setCountry(office.getCountry());
        newOffice.setTerritory(office.getTerritory());
        newOffice.setState(office.getState());
        em.getTransaction().begin();
//        em.persist(newOffice);
        em.remove(office);
        em.getTransaction().commit();
        em.close();
    }
}
