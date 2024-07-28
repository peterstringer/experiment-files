package gwendolen.failuredetection.syntheticexamples._20;import ail.syntax.*;import ail.util.Tuple;import ajpf.util.AJPFLogger;import gwendolen.failuredetection.environments.ReconfigurationWaypointsEnvironment;import gov.nasa.jpf.util.Pair;import java.util.Dictionary;import java.util.Hashtable;public class _20 extends ReconfigurationWaypointsEnvironment {Hashtable<Pair, Pair> failingactions = new Hashtable<>();Pair<String, String> actionTerms;Pair<Term, Term> a;Pair<Term, Term> b;static String logname = "gwendolen.failuredetection._20";public _20() {super();a = new Pair<>(atW7, atW6);b = new Pair<>(atW7, atW2);failingactions.put(a,b);a = new Pair<>(atW6, atW4);b = new Pair<>(atW6, atW6);failingactions.put(a,b);a = new Pair<>(atW8, atW4);b = new Pair<>(atW8, atW7);failingactions.put(a,b);a = new Pair<>(atW4, atW5);b = new Pair<>(atW4, atW3);failingactions.put(a,b);a = new Pair<>(atW7, atW4);b = new Pair<>(atW7, atW6);failingactions.put(a,b);a = new Pair<>(atW5, atW2);b = new Pair<>(atW5, atW5);failingactions.put(a,b);a = new Pair<>(atW1, atW2);b = new Pair<>(atW1, atW7);failingactions.put(a,b);a = new Pair<>(atW2, atW4);b = new Pair<>(atW2, atW3);failingactions.put(a,b);a = new Pair<>(atW4, atW8);b = new Pair<>(atW4, atW0);failingactions.put(a,b);a = new Pair<>(atW4, atW2);b = new Pair<>(atW4, atW4);failingactions.put(a,b);a = new Pair<>(atW3, atW4);b = new Pair<>(atW3, atW7);failingactions.put(a,b);a = new Pair<>(atW3, atW0);b = new Pair<>(atW3, atW1);failingactions.put(a,b);a = new Pair<>(atW3, atW1);b = new Pair<>(atW3, atW0);failingactions.put(a,b);a = new Pair<>(atW1, atW5);b = new Pair<>(atW1, atW2);failingactions.put(a,b);a = new Pair<>(atW7, atW3);b = new Pair<>(atW7, atW0);failingactions.put(a,b);a = new Pair<>(atW1, atW0);b = new Pair<>(atW1, atW3);failingactions.put(a,b);a = new Pair<>(atW8, atW5);b = new Pair<>(atW8, atW4);failingactions.put(a,b);a = new Pair<>(atW4, atW6);b = new Pair<>(atW4, atW0);failingactions.put(a,b);a = new Pair<>(atW7, atW8);b = new Pair<>(atW7, atW6);failingactions.put(a,b);a = new Pair<>(atW0, atW4);b = new Pair<>(atW0, atW6);failingactions.put(a,b);a = new Pair<>(atW5, atW7);b = new Pair<>(atW5, atW3);failingactions.put(a,b);a = new Pair<>(atW4, atW7);b = new Pair<>(atW4, atW2);failingactions.put(a,b);a = new Pair<>(atW0, atW1);b = new Pair<>(atW0, atW2);failingactions.put(a,b);a = new Pair<>(atW7, atW5);b = new Pair<>(atW7, atW2);failingactions.put(a,b);a = new Pair<>(atW3, atW6);b = new Pair<>(atW3, atW8);failingactions.put(a,b);a = new Pair<>(atW4, atW0);b = new Pair<>(atW4, atW4);failingactions.put(a,b);a = new Pair<>(atW5, atW8);b = new Pair<>(atW5, atW4);failingactions.put(a,b);a = new Pair<>(atW1, atW4);b = new Pair<>(atW1, atW5);failingactions.put(a,b);a = new Pair<>(atW4, atW1);b = new Pair<>(atW4, atW6);failingactions.put(a,b);a = new Pair<>(atW1, atW3);b = new Pair<>(atW1, atW6);failingactions.put(a,b);a = new Pair<>(atW5, atW1);b = new Pair<>(atW5, atW6);failingactions.put(a,b);a = new Pair<>(atW6, atW3);b = new Pair<>(atW6, atW2);failingactions.put(a,b);a = new Pair<>(atW8, atW7);b = new Pair<>(atW8, atW1);failingactions.put(a,b);a = new Pair<>(atW2, atW5);b = new Pair<>(atW2, atW1);failingactions.put(a,b);a = new Pair<>(atW2, atW1);b = new Pair<>(atW2, atW4);failingactions.put(a,b);a = new Pair<>(atW6, atW7);b = new Pair<>(atW6, atW0);failingactions.put(a,b);}public Pair checkAction(Action act) { Literal from = new Literal("at"); from.addTerm(act.getTerm(0)); Literal to = new Literal("at"); to.addTerm(act.getTerm(1)); Pair<Term, Term> actionTerms = new Pair<>(from, to); if (failingactions.containsKey(actionTerms)) { actionTerms = failingactions.get(actionTerms); /* action terms are now the failing action terms */ return actionTerms; } else { return null; } } @Override public void processMovement(String agName, Capability capability) { Action act = capability.getAction(); Term origin = act.getTerm(0); Term destination = act.getTerm(1); Predicate new_position = new Predicate("at"); Predicate old_position = new Predicate("at");  if (checkAction(act) != null) { Pair newTerms = checkAction(act); old_position.addTerm(origin); removePercept(old_position); addPercept((Predicate) newTerms._2);} else { new_position.addTerm(destination); old_position.addTerm(origin); removePercept(old_position); addPercept(new_position); } } }