package com.mycompany.orm.persistencia.com.relacionamentos.librarian;

import com.mycompany.orm.persistencia.com.relacionamentos.user.User;

public class Librarian extends User {

    public Librarian(Long id) {
        setId(id);
    }

    public Librarian() {}
}
