package Entidades;

import Entidades.Questions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-27T11:58:16")
@StaticMetamodel(Types.class)
public class Types_ { 

    public static volatile SingularAttribute<Types, Integer> typesId;
    public static volatile SingularAttribute<Types, String> typesType;
    public static volatile ListAttribute<Types, Questions> questionsList;

}