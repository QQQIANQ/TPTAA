package servlets;
import dao.UserDAO;
import jpa.EntityManagerHelper;
import metier.Appointment;
import metier.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="afficheUserInfo",
        urlPatterns={"/AfficheUserInfo"})
public class AfficheUserInfo extends HttpServlet{


    static EntityManager manager;
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        manager = EntityManagerHelper.getEntityManager();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<User> userList = manager.createNamedQuery("allUser",User.class).getResultList();

        System.out.println(userList.size());

        out.append("<HTML><BODY><H1> Recapitulatif des informations Users </H1>"
                    +" User Total :  " + userList.size()+
                    "<table border='1'><tr><th>ID</th><th>Name</th><th>Birthday</th></tr>" );

        for(User u : userList){
            out.append("<tr>"
	            + "<td>" + u.getId()+"</td>"
	            +"<td>" + u.getName() +"</td>"
	            +"<td>" + u.getDateNaissance()+"</td>"
            +"</tr>");
        }

        out.append("</table></BODY></HTML>");

        out.println();

    }
}
