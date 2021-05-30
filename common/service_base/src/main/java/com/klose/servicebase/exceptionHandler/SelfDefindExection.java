package com.klose.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Klose
 * @create 2021-05-26-22:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfDefindExection extends RuntimeException {
    private Integer code;
    private String msg;
}
