package curso.web.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.web.datos.LeerDatos;

/**
 * Servlet implementation class ProvinciasControlador
 */
@WebServlet("")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String provincia = request.getParameter("provincia");
		
		ArrayList<String> listadoProvincias = LeerDatos.obtenerProvincias();
		request.setAttribute("listadoProvincias", listadoProvincias);
		//NO es necesario que se almacene en la sesión, ya que se carga siempre
		//request.getSession().setAttribute("listadoProvincias", listadoProvincias);
		
		if(provincia != null && !provincia.equals("")) {
			
			request.setAttribute("seleccionado", provincia);		

			ArrayList<String> listadoMunicipios = LeerDatos.obtenerMunicipiosXProvincia(provincia);
			request.setAttribute("listadoMunicipios", listadoMunicipios);
		}

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
