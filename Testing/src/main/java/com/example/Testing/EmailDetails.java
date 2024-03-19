package com.example.Testing;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Class
public class EmailDetails {


    private List<String> recipient;
    private String msgBody;
    private String subject;


}
