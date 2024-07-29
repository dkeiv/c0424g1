package org.example.customerlist;

import model.Customer;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Customer List", value = "/customer-list")
public class CustomerListServlet extends HttpServlet {
    protected List<Customer> customerList;

    protected void setup() {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Anne Hathaway", "1990-01-01", "123 Main St, Springfield", "https://resizing.flixster.com/azUalPS6xh6lhRhtTbo52bXgnyE=/218x280/v2/https://resizing.flixster.com/kZNjVexlaQWHQhOnZLMMdCrDWEU=/ems.ZW1zLXByZC1hc3NldHMvY2VsZWJyaXRpZXMvOTRmMWFmOWUtODE1NS00M2EwLWE4ZTQtMjZmYmVkZjE2ODY3LmpwZw=="));
        customerList.add(new Customer("Hugh Jackman", "1985-02-14", "456 Elm St, Springfield", "https://resizing.flixster.com/8LJEg9-Yq-EbCR55gtjCINbkkZc=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/171234_v9_bc.jpg"));
        customerList.add(new Customer("Charlie Brown", "1992-03-30", "789 Oak St, Springfield", "https://resizing.flixster.com/Zf458G7LD3rd7AfkKqCR3dUUwxg=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/51538_v9_bb.jpg"));
        customerList.add(new Customer("Diana Prince", "1987-04-21", "101 Pine St, Springfield", "https://resizing.flixster.com/XIPT8zkyH1JZTjdg9lep89A_TV0=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/1292789_v9_aa.jpg"));
        customerList.add(new Customer("Ethan Hunt", "1980-05-15", "202 Cedar St, Springfield", "https://resizing.flixster.com/aKZD0ZOIIhT1YuBxFNJxe20iqYM=/218x280/v2/https://resizing.flixster.com/vpi-xtSdBvad3lgHJ9aMFwnZXNo=/ems.cHJkLWVtcy1hc3NldHMvY2VsZWJyaXRpZXMvMmYxODg5MzMtODE3MS00ZTI2LThmYmYtZGVmMzE4MmI3MjRiLmpwZw=="));
        customerList.add(new Customer("George Clooney", "1961-05-06", "404 Maple St, Springfield", "https://resizing.flixster.com/N7qO-x-etsC6uzphu-aIOjZRjXE=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/23213_v9_bb.jpg"));
        customerList.add(new Customer("Hannah Montana", "1998-11-23", "505 Ash St, Springfield", "https://resizing.flixster.com/1S5WsAKd4zTAwZGUTsThFzFg6Kc=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/488318_v9_bc.jpg"));
        customerList.add(new Customer("Ian Somerhalder", "1978-12-08", "606 Willow St, Springfield", "https://resizing.flixster.com/GfLqNDhYx87rG17TEb5whqtOdPM=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/173409_v9_bb.jpg"));
        customerList.add(new Customer("Jenna Ortega", "2002-09-27", "707 Fir St, Springfield", "https://resizing.flixster.com/vqCbvJg-W8V_OfFYoPZPJfnaVT0=/218x280/v2/https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/653777_v9_bd.jpg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setup();
        RequestDispatcher rd = request.getRequestDispatcher("customerlist.jsp");
        request.setAttribute("customerList", customerList);
        rd.forward(request, response);
    }
}
