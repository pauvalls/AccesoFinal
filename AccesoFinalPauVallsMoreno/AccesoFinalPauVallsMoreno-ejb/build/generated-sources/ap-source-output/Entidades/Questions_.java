package Entidades;

import Entidades.Answers;
import Entidades.Options;
import Entidades.Types;
import Entidades.Userquestions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-27T11:58:16")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, Integer> questionsId;
    public static volatile ListAttribute<Questions, Answers> answersList;
    public static volatile ListAttribute<Questions, Options> optionsList;
    public static volatile SingularAttribute<Questions, Types> questionsIdType;
    public static volatile SingularAttribute<Questions, String> questionsTitle;
    public static volatile ListAttribute<Questions, Userquestions> userquestionsList;

}