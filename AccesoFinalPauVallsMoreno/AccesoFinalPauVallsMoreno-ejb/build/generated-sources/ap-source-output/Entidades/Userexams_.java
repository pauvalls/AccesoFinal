package Entidades;

import Entidades.Userquestions;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-27T11:58:16")
@StaticMetamodel(Userexams.class)
public class Userexams_ { 

    public static volatile SingularAttribute<Userexams, String> userexamsUserid;
    public static volatile SingularAttribute<Userexams, Date> userexamsEndtime;
    public static volatile SingularAttribute<Userexams, Integer> userexamsId;
    public static volatile SingularAttribute<Userexams, Date> userexamsStarttime;
    public static volatile ListAttribute<Userexams, Userquestions> userquestionsList;

}