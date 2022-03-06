
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package proyecto_0103.ExpressionTree;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Automata extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym2.class;
}

  /** Default constructor. */
  @Deprecated
  public Automata() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Automata(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Automata(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\015\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\004\004\000\002\004\004\000" +
    "\002\004\003\000\002\004\003\000\002\005\004\000\002" +
    "\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\020\004\005\005\004\006\011\007\013\010" +
    "\014\011\015\012\012\001\002\000\020\004\005\005\004" +
    "\006\011\007\013\010\014\011\015\012\012\001\002\000" +
    "\022\002\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010\ufff8" +
    "\011\ufff8\012\ufff8\001\002\000\004\002\026\001\002\000" +
    "\022\002\ufffe\004\ufffe\005\ufffe\006\ufffe\007\ufffe\010\ufffe" +
    "\011\ufffe\012\ufffe\001\002\000\022\002\000\004\005\005" +
    "\004\006\011\007\013\010\014\011\015\012\012\001\002" +
    "\000\020\004\005\005\004\006\011\007\013\010\014\011" +
    "\015\012\012\001\002\000\022\002\ufff7\004\ufff7\005\ufff7" +
    "\006\ufff7\007\ufff7\010\ufff7\011\ufff7\012\ufff7\001\002\000" +
    "\020\004\005\005\004\006\011\007\013\010\014\011\015" +
    "\012\012\001\002\000\020\004\005\005\004\006\011\007" +
    "\013\010\014\011\015\012\012\001\002\000\020\004\005" +
    "\005\004\006\011\007\013\010\014\011\015\012\012\001" +
    "\002\000\022\002\ufffd\004\ufffd\005\ufffd\006\ufffd\007\ufffd" +
    "\010\ufffd\011\ufffd\012\ufffd\001\002\000\022\002\ufffc\004" +
    "\ufffc\005\ufffc\006\ufffc\007\ufffc\010\ufffc\011\ufffc\012\ufffc" +
    "\001\002\000\022\002\ufff9\004\ufff9\005\ufff9\006\ufff9\007" +
    "\ufff9\010\ufff9\011\ufff9\012\ufff9\001\002\000\022\002\ufff5" +
    "\004\ufff5\005\ufff5\006\ufff5\007\ufff5\010\ufff5\011\ufff5\012" +
    "\ufff5\001\002\000\022\002\ufffb\004\ufffb\005\ufffb\006\ufffb" +
    "\007\ufffb\010\ufffb\011\ufffb\012\ufffb\001\002\000\020\004" +
    "\005\005\004\006\011\007\013\010\014\011\015\012\012" +
    "\001\002\000\022\002\ufff6\004\ufff6\005\ufff6\006\ufff6\007" +
    "\ufff6\010\ufff6\011\ufff6\012\ufff6\001\002\000\022\002\uffff" +
    "\004\uffff\005\uffff\006\uffff\007\uffff\010\uffff\011\uffff\012" +
    "\uffff\001\002\000\004\002\001\001\002\000\022\002\ufffa" +
    "\004\ufffa\005\ufffa\006\ufffa\007\ufffa\010\ufffa\011\ufffa\012" +
    "\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\010\002\005\003\007\004\006\001\001\000" +
    "\010\004\020\005\026\006\022\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\004\024\001" +
    "\001\000\010\004\020\005\021\006\022\001\001\000\002" +
    "\001\001\000\004\004\017\001\001\000\004\004\016\001" +
    "\001\000\004\004\015\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\004\020\006\023\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Automata$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Automata$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Automata$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private Symbol s;
    public String error = "";
    public static ArrayList<GraphNode> GraphVariables = new ArrayList<GraphNode>();
    public static ArrayList<String> GraphText = new ArrayList<String>();
    public static ArrayList<Siguiente> nexts = new ArrayList<Siguiente>();
    public int actualHoja = 0;

    public int mas = 1;
    public int interrogacion = 1;
    public int or = 1;
    public int punto = 1;
    public int asterisco = 1;
    public int cadena = 1;
    public int cadenall = 1;
    public static Node primero = new Node("","","","",false,0);
    public static Node head = new Node("","","","",false,0);
    public int index = 1;

    public void syntax_error(Symbol s){
        error += "Advertencia : Error sintáctico con \"" + s.value + 
        "\" en la fila " + (s.right + 1) + " y columna " + (s.left + 1) + "\n";
    }

    public Symbol getS(){
        return this.s;
    }
    
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
    error += "Advertencia : Error sintáctico irrecuperable con \"" + s.value + 
    "\" en la fila " + (s.right + 1) + " y columna " + (s.left + 1) + "\n";
    }

    public String getSyntaxError() {
        return this.error;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Automata$actions {
  private final Automata parser;

  /** Constructor */
  CUP$Automata$actions(Automata parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Automata$do_action_part00000000(
    int                        CUP$Automata$act_num,
    java_cup.runtime.lr_parser CUP$Automata$parser,
    java.util.Stack            CUP$Automata$stack,
    int                        CUP$Automata$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Automata$result;

      /* select the action based on the action number */
      switch (CUP$Automata$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		RESULT = start_val;
              CUP$Automata$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Automata$parser.done_parsing();
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= REGEXS 
            {
              Object RESULT =null;
		int regleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int regright = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node reg = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		System.out.println("Inicio de análisis de automata");
              CUP$Automata$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // REGEXS ::= REGEXS REGEX 
            {
              Node RESULT =null;
		int pluralRleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int pluralRright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		Node pluralR = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int singleRleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int singleRright = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node singleR = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;

              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEXS",1, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // REGEXS ::= REGEX 
            {
              Node RESULT =null;
		int singleRleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int singleRright = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node singleR = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		
    actualHoja +=1;
    nexts.add(new Siguiente(primero.first,Integer.toString(actualHoja)));
    GraphVariables.add(new GraphNode("HASH [style=filled color=lightblue label=<<table border=\"0\">"
                        +"<tr><td bgcolor=\"black\"><font color=\"white\">"+actualHoja+"</font></td><td cellpadding=\"10\">#</td><td bgcolor=\"white\">"+actualHoja+"</td></tr>"
                        +"<tr><td></td><td bgcolor=\"#84ff82\">"+actualHoja+"</td><td></td></tr></table>>];",actualHoja,"#"));
    GraphText.add("P0 -> {"+primero.name+",HASH};\n");
    String first = null;
    String last = null;
    if (primero.anulable==true){
        first = Integer.toString(actualHoja);
        last = primero.last + Integer.toString(actualHoja);
        GraphVariables.add(new GraphNode("P0 [style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
        Node h = new Node(last,".",first,"",false,0);
        head = h;
    }else{
        first = Integer.toString(actualHoja);
        last = primero.last;
        GraphVariables.add(new GraphNode("P0[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
        Node h = new Node(last,".",first,"",false,0);
        head = h;
    }


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEXS",1, ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // REGEX ::= Mas REGEX 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node r2 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		

    Node n1 = r2;
    String first = null;
    String last = null;
    boolean anulable = false;
    nexts.add(new Siguiente(n1.first,n1.last));
    GraphText.add("MAS"+mas+"-> {"+n1.name+"};\n");
    if (n1.anulable==true){
        first = n1.first;
        last = n1.last;
        GraphVariables.add(new GraphNode("MAS"+mas+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">+</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"+"));
        anulable = true;
    }else{
        first = n1.first;
        last = n1.last;
        GraphVariables.add(new GraphNode("MAS"+mas+"[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">+</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"+"));
    }
    Node n = new Node(last,r,first,"MAS"+mas,anulable,0);
    primero = n;
    RESULT = n;
    mas+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // REGEX ::= Interrogacion REGEX 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node r2 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		

    Node n1 = r2;
    String first = n1.first;
    String last = n1.last;
    boolean anulable = true;
    GraphText.add("IN"+interrogacion+"-> {"+n1.name+"};\n");
    GraphVariables.add(new GraphNode("IN"+interrogacion+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">?</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"?"));
    Node n = new Node(last,r,first,"IN"+interrogacion,anulable,0);
    primero = n;
    RESULT = n;
    interrogacion+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // REGEX ::= Or TWOREGEX 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		ArrayList<Node> r2 = (ArrayList<Node>)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		

    ArrayList<Node> array = r2;
    String first = null;
    String last = null;
    boolean anulable = false;
    GraphText.add("OR"+or+"-> {"+array.get(0).name+","+array.get(1).name+"};\n");
    if (array.get(0).anulable==true && array.get(1).anulable==true){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("OR"+or+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">|</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"|"));
        anulable = true;
    }else if (array.get(0).anulable==true && array.get(1).anulable==false){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("OR"+or+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">|</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"|"));
        anulable = true;
    }else if (array.get(0).anulable==false && array.get(1).anulable==true){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("OR"+or+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">|</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"|"));
        anulable = true;
    }else if (array.get(0).anulable==false && array.get(1).anulable==false){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("OR"+or+"[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">|</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"|"));
    }
    Node n = new Node(last,r,first,"OR"+or,anulable,0);
    primero = n;
    RESULT = n;
    or+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // REGEX ::= Punto TWOREGEX 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		ArrayList<Node> r2 = (ArrayList<Node>)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		
    ArrayList<Node> array = r2;
    nexts.add(new Siguiente(array.get(0).first,array.get(1).last));
    String first = null;
    String last = null;
    boolean anulable = false;
    GraphText.add("P"+punto+"-> {"+array.get(0).name+","+array.get(1).name+"};\n");
    if (array.get(0).anulable==true && array.get(1).anulable==true){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("P"+punto+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
        anulable = true;
    }else if (array.get(0).anulable==true && array.get(1).anulable==false){
        first = array.get(1).first;
        last = array.get(0).last+","+array.get(1).last;
        GraphVariables.add(new GraphNode("P"+punto+"[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
    }else if (array.get(0).anulable==false && array.get(1).anulable==true){
        first = array.get(0).first+","+array.get(1).first;
        last = array.get(0).last;
        GraphVariables.add(new GraphNode("P"+punto+"[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
    }else if (array.get(0).anulable==false && array.get(1).anulable==false){
        first = array.get(1).first;
        last = array.get(0).last;
        GraphVariables.add(new GraphNode("P"+punto+"[style=filled color=lightblue label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">.</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"."));
    }
    Node n = new Node(last,r,first,"P"+punto,anulable,0);
    primero = n;
    RESULT = n;
    punto+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // REGEX ::= Asterisco REGEX 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node r2 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		

    Node n1 = r2;
    String first = n1.first;
    String last = n1.last;
    boolean anulable = true;
    nexts.add(new Siguiente(n1.first,n1.last));
    GraphText.add("AS"+asterisco+"-> {"+n1.name+"};\n");
    GraphVariables.add(new GraphNode("AS"+asterisco+"[style=filled color=\"#ff8282\" label=<<table border=\"0\">"
            +"<tr><td bgcolor=\"black\"><font color=\"white\">"+last+"</font></td><td cellpadding=\"10\">*</td><td bgcolor=\"white\">"+first+"</td></tr>"
            +"</table>>];\n",0,"*"));
    Node n = new Node(last,r,first,"AS"+asterisco,anulable,0);
    primero = n;
    RESULT = n;
    asterisco+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // REGEX ::= Cadena 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		
    actualHoja+=1;
    String text = r;
    String i = Integer.toString(actualHoja);
    Node n = new Node(i,text,i,"Cad"+cadena,false,index);
    GraphVariables.add(new GraphNode("Cad"+cadena+"[style=filled color=lightblue label=<<table border=\"0\">"
        +"<tr><td bgcolor=\"black\"><font color=\"white\">"+actualHoja+"</font></td><td cellpadding=\"10\">"+text+"</td><td bgcolor=\"white\">"+actualHoja+"</td></tr>"
        +"<tr><td></td><td bgcolor=\"#84ff82\">"+actualHoja+"</td><td></td></tr></table>>];\n",index,text));
    primero = n;
    RESULT = n;
    index+=1;
    cadena+=1;


              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // REGEX ::= Cadena_Ll 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		
    actualHoja+=1;
    String text = r;
    String i = Integer.toString(actualHoja);
    Node n = new Node(i,text,i,"Cll"+cadenall,false,index);
    GraphVariables.add(new GraphNode("Cll"+cadenall+"[style=filled color=lightblue label=<<table border=\"0\">"
        +"<tr><td bgcolor=\"black\"><font color=\"white\">"+actualHoja+"</font></td><td cellpadding=\"10\">"+text+"</td><td bgcolor=\"white\">"+actualHoja+"</td></tr>"
        +"<tr><td></td><td bgcolor=\"#84ff82\">"+actualHoja+"</td><td></td></tr></table>>];\n",index,text));
    primero = n;
    RESULT = n;
    index+=1;
    cadenall+=1;

              CUP$Automata$result = parser.getSymbolFactory().newSymbol("REGEX",2, ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // TWOREGEX ::= AUXREGEX AUXREGEX 
            {
              ArrayList<Node> RESULT =null;
		int r1left = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).left;
		int r1right = ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)).right;
		Node r1 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.elementAt(CUP$Automata$top-1)).value;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node r2 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		

    ArrayList<Node> r = new ArrayList<Node>();
    r.add(r1);
    r.add(r2);
    RESULT = r;

              CUP$Automata$result = parser.getSymbolFactory().newSymbol("TWOREGEX",3, ((java_cup.runtime.Symbol)CUP$Automata$stack.elementAt(CUP$Automata$top-1)), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // AUXREGEX ::= REGEX 
            {
              Node RESULT =null;
		int r2left = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).left;
		int r2right = ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()).right;
		Node r2 = (Node)((java_cup.runtime.Symbol) CUP$Automata$stack.peek()).value;
		
    RESULT = r2;

              CUP$Automata$result = parser.getSymbolFactory().newSymbol("AUXREGEX",4, ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), ((java_cup.runtime.Symbol)CUP$Automata$stack.peek()), RESULT);
            }
          return CUP$Automata$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Automata$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Automata$do_action(
    int                        CUP$Automata$act_num,
    java_cup.runtime.lr_parser CUP$Automata$parser,
    java.util.Stack            CUP$Automata$stack,
    int                        CUP$Automata$top)
    throws java.lang.Exception
    {
              return CUP$Automata$do_action_part00000000(
                               CUP$Automata$act_num,
                               CUP$Automata$parser,
                               CUP$Automata$stack,
                               CUP$Automata$top);
    }
}

}