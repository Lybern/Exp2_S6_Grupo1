package com.minimarket.entity;

import org.junit.jupiter.api.Test;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Suite de pruebas automatizadas para la validación estructural de la capa de Dominio (Entities).
 * Utiliza OpenPojo para testear de manera exhaustiva y automatizada todos los métodos 
 * mutadores (Setters) y accesores (Getters), asegurando una métrica de cobertura del 100% 
 * en la capa Entity para métricas de JaCoCo.
 */
public class EntidadesPojoTest {

    @Test
    void testTodosLosGettersYSetters() {
        Validator validator = ValidatorBuilder.create()
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        // Escanea y prueba automáticamente TODAS las clases del paquete entity
        validator.validate(PojoClassFactory.getPojoClassesRecursively("com.minimarket.entity", null));
    }
}