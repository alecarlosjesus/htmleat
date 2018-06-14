package rep.estomac.eat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEat
 */
@WebServlet("/tasty")
public class ServletEat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = "";
		String n = "";
		int beg=0;
		
		//String name = request.getParameter("character").replaceAll(" ", "+");
		
		try {
			//URL url = new URL("https://secure.tibia.com/community/?subtopic=characters&name="+name);
			URL url = new URL("https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Society+of+Exile&action=overview");
						
			//URI uri = url.toURI();
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			//Item de retenção
			//"?subtopic=characters&amp;name="
		
			int count = 0;
			
			while (br.ready()) {
				n = br.readLine();
				
				beg = n.indexOf("?subtopic=characters&amp;name=");
				
				if(beg > 0 ) {
					System.out.println("\nFOUND : " + count++);
					
				}

			}
			br.close();
			
			
			
			
			
			request.setAttribute("mainStream", s);
			request.getRequestDispatcher("index.jsp").forward(request, response); 
						
		} catch (MalformedURLException excecao) {
			excecao.printStackTrace();
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}

		
	}

}
