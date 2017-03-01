package Entidades;

import Entidades.Questions;
import Entidades.Useranswers;
import Entidades.Userexams;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-28T19:01:03")
@StaticMetamodel(Userquestions.class)
public class Userquestions_ { 

    public static volatile ListAttribute<Userquestions, Useranswers> useranswersList;
    public static volatile SingularAttribute<Userquestions, Questions> userquestionsIdquestion;
    public static volatile SingularAttribute<Userquestions, Integer> userquestionsId;
    public static volatile SingularAttribute<Userquestions, Userexams> userquestionsIdexam;

}