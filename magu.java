/* magu.java */
/* Generated By:JavaCC: Do not edit this line. magu.java */
import java.util.*;

class magu implements maguConstants {

        public static void main(String[] args) throws ParseException
        {
                try
                {
                        magu scanner = new magu(System.in);
                        scanner.Programa();
                        System.out.println("OK!");
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("Error!");
                }
        }

        Stack pOperators = new Stack();
        Stack pOperands = new Stack();
        Queue<Cuadruplo> cuadruplos = new LinkedList<Cuadruplo>();

  final public void Programa() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_ID:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Asignacion();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_FUNC:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      Definicion_Func();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_ARR:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      Arreglo();
    }
    Secuencia();
    jj_consume_token(0);
  }

  final public void Func() throws ParseException {Token o, op1, op2, r;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_FORWARD:{
      o = jj_consume_token(TK_FORWARD);
      jj_consume_token(TK_LPAR);
      Exp();
      jj_consume_token(TK_RPAR);
Cuadruplo quad = new Cuadruplo();
                        quad.operador = o;
                        Cuadruplo.displayCuadruplo(quad);
      break;
      }
    case TK_LEFT:{
      jj_consume_token(TK_LEFT);
      jj_consume_token(TK_LPAR);
      Exp();
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_RIGHT:{
      jj_consume_token(TK_RIGHT);
      jj_consume_token(TK_LPAR);
      Exp();
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_INPUT:{
      jj_consume_token(TK_INPUT);
      jj_consume_token(TK_LPAR);
      jj_consume_token(TK_ID);
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_PRINT:{
      jj_consume_token(TK_PRINT);
      jj_consume_token(TK_LPAR);
      if (jj_2_1(2)) {
        jj_consume_token(TK_ID);
        jj_consume_token(TK_LBRACKET);
        Exp();
        jj_consume_token(TK_RBRACKET);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_ID:{
          jj_consume_token(TK_ID);
          break;
          }
        case TK_STRING:{
          jj_consume_token(TK_STRING);
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_PLUS:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_4;
        }
        jj_consume_token(TK_PLUS);
        if (jj_2_2(2)) {
          jj_consume_token(TK_ID);
          jj_consume_token(TK_LBRACKET);
          Exp();
          jj_consume_token(TK_RBRACKET);
        } else {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case TK_ID:{
            jj_consume_token(TK_ID);
            break;
            }
          case TK_STRING:{
            jj_consume_token(TK_STRING);
            break;
            }
          default:
            jj_la1[5] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_PENCILUP:{
      jj_consume_token(TK_PENCILUP);
      jj_consume_token(TK_LPAR);
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_PENCILDOWN:{
      jj_consume_token(TK_PENCILDOWN);
      jj_consume_token(TK_LPAR);
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_MOVE:{
      jj_consume_token(TK_MOVE);
      jj_consume_token(TK_LPAR);
      Exp();
      jj_consume_token(TK_COMMA);
      Exp();
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_CURVE:{
      jj_consume_token(TK_CURVE);
      jj_consume_token(TK_LPAR);
      Exp();
      jj_consume_token(TK_COMMA);
      Exp();
      jj_consume_token(TK_RPAR);
      break;
      }
    case TK_HOME:{
      jj_consume_token(TK_HOME);
      jj_consume_token(TK_LPAR);
      jj_consume_token(TK_RPAR);
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Funcion() throws ParseException {
    jj_consume_token(TK_ID);
    jj_consume_token(TK_LPAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_CTE_I:
    case TK_ID:{
      Exp();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_COMMA:{
          ;
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          break label_5;
        }
        jj_consume_token(TK_COMMA);
        Exp();
      }
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(TK_RPAR);
  }

  final public void Exp() throws ParseException {Token o, op1, op2;
    Termino();
if( !pOperators.empty()) {

                        if ( ((Token)pOperators.peek()).image.equals("+") || ((Token)pOperators.peek()).image.equals("-")  ) {

                                op2 = (Token)pOperands.pop();
                                op1 = (Token)pOperands.pop();
                                o = (Token)pOperators.pop();

                                Cuadruplo quad = new Cuadruplo();
                        quad.operador = o;
                        quad.oper1 = op1;
                        quad.oper2 = op2;
                        Cuadruplo.displayCuadruplo(quad);

                        System.out.println("ENTRA AQUI");
                    }
                }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_PLUS:
      case TK_MINUS:{
        ;
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_PLUS:{
        o = jj_consume_token(TK_PLUS);
pOperators.push(o); // meter el + a la stack de operadores

                        System.out.println("Entra aqui " + pOperators.peek());
        Termino();
if( !pOperators.empty()) {

                                if ( ((Token)pOperators.peek()).image.equals("+") || ((Token)pOperators.peek()).image.equals("-")  ) {

                                        op2 = (Token)pOperands.pop();
                                        op1 = (Token)pOperands.pop();
                                        o = (Token)pOperators.pop();

                                        Cuadruplo quad = new Cuadruplo();
                                        quad.operador = o;
                                        quad.oper1 = op1;
                                        quad.oper2 = op2;
                                        Cuadruplo.displayCuadruplo(quad);

                                        System.out.println("ENTRA AQUI");
                                }
                        }
        break;
        }
      case TK_MINUS:{
        o = jj_consume_token(TK_MINUS);
pOperators.push(o); // meter el - a la stack de operadores

        Termino();
if( !pOperators.empty()) {

                                if ( ((Token)pOperators.peek()).image.equals("+") || ((Token)pOperators.peek()).image.equals("-")  ) {

                                        op2 = (Token)pOperands.pop();
                                        op1 = (Token)pOperands.pop();
                                        o = (Token)pOperators.pop();

                                        Cuadruplo quad = new Cuadruplo();
                                        quad.operador = o;
                                        quad.oper1 = op1;
                                        quad.oper2 = op2;
                                        Cuadruplo.displayCuadruplo(quad);

                                        System.out.println("ENTRA AQUI");
                                }
                        }
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Termino() throws ParseException {Token o, op1, op2;
    Factor();
if( !pOperators.empty()) {

                        if ( ((Token)pOperators.peek()).image.equals("*") || ((Token)pOperators.peek()).image.equals("/")  ) {

                                op2 = (Token)pOperands.pop();
                                op1 = (Token)pOperands.pop();
                                o = (Token)pOperators.pop();

                                Cuadruplo quad = new Cuadruplo();
                        quad.operador = o;
                        quad.oper1 = op1;
                        quad.oper2 = op2;
                        Cuadruplo.displayCuadruplo(quad);

                        System.out.println("ENTRA AQUI");
                    }
                }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_MULT:
      case TK_DIV:{
        ;
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_MULT:{
        o = jj_consume_token(TK_MULT);
pOperators.push(o); // meter el * a la stack de operadores

        Factor();
if( !pOperators.empty()) {

                                if ( ((Token)pOperators.peek()).image.equals("*") || ((Token)pOperators.peek()).image.equals("/")  ) {

                                        op2 = (Token)pOperands.pop();
                                        op1 = (Token)pOperands.pop();
                                        o = (Token)pOperators.pop();

                                        Cuadruplo quad = new Cuadruplo();
                                        quad.operador = o;
                                        quad.oper1 = op1;
                                        quad.oper2 = op2;
                                        Cuadruplo.displayCuadruplo(quad);

                                        System.out.println("ENTRA AQUI");
                                }
                        }
        break;
        }
      case TK_DIV:{
        o = jj_consume_token(TK_DIV);
pOperators.push(o); // meter el / a la stack de operadores

        Factor();
if( !pOperators.empty()) {

                                if ( ((Token)pOperators.peek()).image.equals("*") || ((Token)pOperators.peek()).image.equals("/")  ) {

                                        op2 = (Token)pOperands.pop();
                                        op1 = (Token)pOperands.pop();
                                        o = (Token)pOperators.pop();

                                        Cuadruplo quad = new Cuadruplo();
                                        quad.operador = o;
                                        quad.oper1 = op1;
                                        quad.oper2 = op2;
                                        Cuadruplo.displayCuadruplo(quad);

                                        System.out.println("ENTRA AQUI");
                                }
                        }
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Factor() throws ParseException {Token o;
    if (jj_2_3(2)) {
      //indice de arreglo
              //t = <TK_ID> <TK_LBRACKET> Exp() <TK_RBRACKET>
      
              //|
      
              // variable
              o = jj_consume_token(TK_ID);
pOperands.push(o); // meter el id a la stack de operandos

                System.out.println("Entra aqui " + pOperands.peek() );
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_CTE_I:{
        //constante
                o = jj_consume_token(TK_CTE_I);
pOperands.push(o); // meter la constante a la stack de operandos

                System.out.println("Entra aqui " + pOperands.peek());
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Asignacion() throws ParseException {
    if (jj_2_4(2)) {
      jj_consume_token(TK_ID);
      jj_consume_token(TK_EQ);
      Exp();
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_ID:{
        jj_consume_token(TK_ID);
        jj_consume_token(TK_LBRACKET);
        Exp();
        jj_consume_token(TK_RBRACKET);
        jj_consume_token(TK_EQ);
        Exp();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Bool() throws ParseException {
    Exp();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_NE:
    case TK_EQT:
    case TK_LT:
    case TK_GT:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_LT:{
        jj_consume_token(TK_LT);
        Exp();
        break;
        }
      case TK_GT:{
        jj_consume_token(TK_GT);
        Exp();
        break;
        }
      case TK_NE:{
        jj_consume_token(TK_NE);
        Exp();
        break;
        }
      case TK_EQT:{
        jj_consume_token(TK_EQT);
        Exp();
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[16] = jj_gen;
      ;
    }
  }

  final public void Secuencia() throws ParseException {
    jj_consume_token(TK_LBRACE);
    if (jj_2_5(2)) {
      Funcion();
    } else if (jj_2_6(2)) {
      Func();
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_WHILE:{
        While();
        break;
        }
      case TK_ID:{
        Asignacion();
        break;
        }
      case TK_IF:{
        Condicion();
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TK_COMMA:{
        ;
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
      jj_consume_token(TK_COMMA);
      if (jj_2_7(2)) {
        Funcion();
      } else if (jj_2_8(2)) {
        Func();
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_WHILE:{
          While();
          break;
          }
        case TK_ID:{
          Asignacion();
          break;
          }
        case TK_IF:{
          Condicion();
          break;
          }
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    jj_consume_token(TK_RBRACE);
  }

  final public void While() throws ParseException {
    jj_consume_token(TK_WHILE);
    jj_consume_token(TK_LPAR);
    Bool();
    jj_consume_token(TK_RPAR);
    Secuencia();
  }

  final public void Definicion_Func() throws ParseException {
    jj_consume_token(TK_FUNC);
    jj_consume_token(TK_ID);
    jj_consume_token(TK_LPAR);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_ID:{
      jj_consume_token(TK_ID);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_COMMA:{
          ;
          break;
          }
        default:
          jj_la1[20] = jj_gen;
          break label_9;
        }
        jj_consume_token(TK_COMMA);
        jj_consume_token(TK_ID);
      }
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(TK_RPAR);
    Secuencia();
  }

  final public void Condicion() throws ParseException {
    jj_consume_token(TK_IF);
    jj_consume_token(TK_LPAR);
    Bool();
    jj_consume_token(TK_RPAR);
    Secuencia();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_ELSE:{
      jj_consume_token(TK_ELSE);
      Secuencia();
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      ;
    }
  }

  final public void Arreglo() throws ParseException {
    jj_consume_token(TK_ARR);
    jj_consume_token(TK_ID);
    jj_consume_token(TK_LBRACKET);
    Exp();
    jj_consume_token(TK_RBRACKET);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TK_EQ:{
      jj_consume_token(TK_EQ);
      jj_consume_token(TK_LPAR);
      Exp();
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case TK_COMMA:{
          ;
          break;
          }
        default:
          jj_la1[23] = jj_gen;
          break label_10;
        }
        jj_consume_token(TK_COMMA);
        Exp();
      }
      jj_consume_token(TK_RPAR);
      break;
      }
    default:
      jj_la1[24] = jj_gen;
      ;
    }
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_3R_22()
 {
    if (jj_scan_token(TK_HOME)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3R_11()
 {
    if (jj_scan_token(TK_ID)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3R_21()
 {
    if (jj_scan_token(TK_CURVE)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3R_20()
 {
    if (jj_scan_token(TK_MOVE)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_8()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(TK_ID)) return true;
    if (jj_scan_token(TK_LBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_19()
 {
    if (jj_scan_token(TK_PENCILDOWN)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_6()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_18()
 {
    if (jj_scan_token(TK_PENCILUP)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_3()
 {
    if (jj_scan_token(TK_ID)) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(TK_PRINT)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_4()
 {
    if (jj_scan_token(TK_ID)) return true;
    if (jj_scan_token(TK_EQ)) return true;
    return false;
  }

  private boolean jj_3_7()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_scan_token(TK_INPUT)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    if (jj_scan_token(TK_RIGHT)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_5()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_scan_token(TK_LEFT)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3_2()
 {
    if (jj_scan_token(TK_ID)) return true;
    if (jj_scan_token(TK_LBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    if (jj_scan_token(TK_FORWARD)) return true;
    if (jj_scan_token(TK_LPAR)) return true;
    return false;
  }

  private boolean jj_3R_12()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  /** Generated Token Manager. */
  public maguTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x8000,0x4000,0x0,0x10000000,0x0,0x7fe,0x8000000,0x0,0x30000000,0x30000000,0xc0000000,0xc0000000,0x0,0x0,0x1e0000,0x1e0000,0x1800,0x8000000,0x1800,0x8000000,0x0,0x2000,0x8000000,0x10000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x2,0x0,0x0,0x6,0x0,0x6,0x0,0x0,0x3,0x0,0x0,0x0,0x0,0x1,0x2,0x0,0x0,0x2,0x0,0x2,0x0,0x2,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[8];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public magu(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public magu(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new maguTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public magu(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new maguTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public magu(maguTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(maguTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[39];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 39; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 8; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
