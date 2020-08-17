package com.acmday.transaction.server.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String name;
    String address;
}
