package com.pragma.restaurant.infraestructure.output.repository.orders;

import java.util.Date;

public interface IOrdersResponseRepository {
    Long geid();
    Long getid_client();
    Date getdate();
    String getstatus();

    Long getid_chef();

    Long getid_restaurant();
}
