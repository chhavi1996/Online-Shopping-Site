import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class buy extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		doGet(req,res);
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {

		PrintWriter out=res.getWriter();
		String name=req.getParameter("dressname");
		int price=Integer.parseInt(req.getParameter("dressprice"));
		String size=req.getParameter("size");
		String selected_size;

		if("S".equals(size))
			selected_size="S";
		else if("M".equals(size))
			selected_size="M";
		else if("L".equals(size))
			selected_size="L";
		else if("XL".equals(size))
			selected_size="XL";
		else if("XLL".equals(size))
			selected_size="XLL";	

		int qty=Integer.parseInt(req.getParameter("qty"));

		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","mysql@123");
			PreparedStatement pst=con.prepareStatement("Insert into details values(?,?,?,?);");
			pst.setString(1,name);
			pst.setInt(2,price);
			pst.setString(3,selected_size);
			pst.setInt(4,qty);

			int rs=pst.executeUpdate();

			if(rs!=0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("buy.html");
				rd.forward(req,res);
			}
			else
			{
				out.println("failed!!!");
			}

		}
		catch(Exception e)
		{
			out.println("failed!!!"+e.getMessage());
		}
	}
}
