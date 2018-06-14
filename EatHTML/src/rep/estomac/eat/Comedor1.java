package rep.estomac.eat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Comedor1 {

	public static void main(String args[]){
		

		String s = "";
		String n = "";
		int beg=0;
		
		List<String> inativos;
		
		//String name = request.getParameter("character").replaceAll(" ", "+");
		
		try {
			//URL url = new URL("https://secure.tibia.com/community/?subtopic=characters&name="+name);
			URL url = new URL("https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Society+of+Exile&action=overview");
						
			//URI uri = url.toURI();
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			//Itens de reten��o
			//"?subtopic=characters&amp;name="
			//</td><TD><A HREF="https://secure.tibia.com/community/?subtopic=characters&name=Kotter">Kotter</A> (Lets Rock)</TD>
		
			int count = 0;
			
			while (br.ready()) {
				n = br.readLine();
							
				beg = n.indexOf("?subtopic=characters&name=");
				
				if(beg > 0 ) {
					//System.out.println(n + " - FOUND POSITION = : "  + beg + " - " + count++);
					
					String nomeChar = "";
					 
					nomeChar = n.substring((n.lastIndexOf("?subtopic=characters&name=")+"?subtopic=characters&name=".length()), n.lastIndexOf('"'));
					
					System.out.println(pegaInativos(nomeChar));
					
				}

			}
			br.close();
		} catch (MalformedURLException excecao) {
			excecao.printStackTrace();
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
		
	}
	
	
	public static String pegaInativos(String nomeChar) {
		
		//Itens de reten��o
		//<td>Last Login:</td><td>Jun 12 2018, 11:53:49 CEST</td>
		//<table border="0" cellspacing="1" cellpadding="4" width="100%"><tr bgcolor=#505050><td colspan=2 class=white><b>Character Information</b></td></tr><tr bgcolor=#F1E0C6><td width=20%>Name:</td><td>Pexao <div style="float: right"></div></td></tr><tr bgcolor=#D4C0A1><td>Sex:</td><td>male</td></tr><tr bgcolor=#F1E0C6><td>Vocation:</td><td>Elite Knight</td></tr><tr bgcolor=#D4C0A1><td>Level:</td><td>234</td></tr><tr bgcolor=#F1E0C6><td><nobr>Achievement Points:</nobr></td><td>308</td></tr><tr bgcolor=#D4C0A1><td>World:</td><td>Astera</td></tr><tr bgcolor=#F1E0C6><td>Former World:</td><td>Laudera</td></tr><tr bgcolor=#D4C0A1><td>Residence:</td><td>Roshamuul</td></tr><tr bgcolor=#F1E0C6><td>Guild&#160;Membership:</td><td>Force of the <a href="https://secure.tibia.com/community/?subtopic=guilds&page=view&GuildName=Society+of+Exile&amp;character=Pexao&amp;action=characters" >Society&#160;of&#160;Exile</a></td></tr><tr bgcolor=#D4C0A1><td>Last Login:</td><td>Jun&#160;13&#160;2018,&#160;00:55:45&#160;CEST</td></tr><tr bgcolor=#F1E0C6><td>Account&#160;Status:</td><td>Premium Account</td></tr></table>
		
		String s = "";
		try {
			//nomeChar = nomeChar.replace("%27", "'");
			URL url = new URL("https://secure.tibia.com/community/?subtopic=characters&name="+nomeChar);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			while (br.ready()) {
				s = br.readLine();
				
				if(s.indexOf("<td>Last Login:</td>") > 0) {
					System.out.println((s.lastIndexOf("<td>Last Login:</td>")+("<td>Last Login:</td><td>").length()));
					s = s.substring((s.lastIndexOf("<td>Last Login:</td>")+("<td>Last Login:</td><td>").length()), (s.lastIndexOf("<td>Last Login:</td>")+("<td>Last Login:</td><td>").length())+"xxxxxxxxxxx".length());
					return s;
				}
			}
			br.close();
			
			return "ERROR";
			
		} catch (MalformedURLException excecao) {
			return null;
		} catch (IOException excecao) {
			return null;
		}
   }
}
