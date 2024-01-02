package controlador;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Libro;
import modelo.LibroDAO;

/**
 * Servlet implementation class BibliotecaController
 */
@WebServlet(urlPatterns ={"","/insertar"})
public class BibliotecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher despachador = null;
		if (request.getServletPath().equals("")) {
			try {
				LibroDAO libroDAO = new LibroDAO();
				ArrayList<Libro> libros;
				libros = libroDAO.getLibros();
				request.setAttribute("libros", libros);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error",e.getMessage());
			}
			despachador = request.getServletContext().getRequestDispatcher("/index.jsp");
		} else if (request.getServletPath().equals("/insertar")) {
			try {
				LibroDAO libroDAO = new LibroDAO();
				Libro libro = new Libro(Integer.parseInt(request.getParameter("isbn")),
						request.getParameter("titulo"),request.getParameter("autor"));
				libroDAO.insertar(libro);
				request.setAttribute("info", "Libro "+ libro +" añadido");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error",e.getMessage());
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error",e.getMessage());
			}
			despachador = request.getServletContext().getRequestDispatcher("/");
		}
		despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
