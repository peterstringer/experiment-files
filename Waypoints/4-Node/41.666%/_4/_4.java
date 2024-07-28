package gwendolen.failuredetection.syntheticexamples._4;import ail.syntax.*;import ail.util.Tuple;import ajpf.util.AJPFLogger;import gwendolen.failuredetection.environments.ReconfigurationWaypointsEnvironment;import gov.nasa.jpf.util.Pair;import java.util.Dictionary;import java.util.Hashtable;public class _4 extends ReconfigurationWaypointsEnvironment {Hashtable<Pair, Pair> failingactions = new Hashtable<>();Pair<String, String> actionTerms;Pair<Term, Term> a;Pair<Term, Term> b;static String logname = "gwendolen.failuredetection._4";public _4() {super();a = new Pair<>(atW1, atW0);b = new Pair<>(atW1, atW3);failingactions.put(a,b);a = new Pair<>(atW1, atW3);b = new Pair<>(atW1, atW0);failingactions.put(a,b);a = new Pair<>(atW2, atW1);b = new Pair<>(atW2, atW0);failingactions.put(a,b);a = new Pair<>(atW1, atW2);b = new Pair<>(atW1, atW0);failingactions.put(a,b);a = new Pair<>(atW0, atW1);b = new Pair<>(atW0, atW2);failingactions.put(a,b);}public Pair checkAction(Action act) { Literal from = new Literal("at"); from.addTerm(act.getTerm(0)); Literal to = new Literal("at"); to.addTerm(act.getTerm(1)); Pair<Term, Term> actionTerms = new Pair<>(from, to); if (failingactions.containsKey(actionTerms)) { actionTerms = failingactions.get(actionTerms); /* action terms are now the failing action terms */ return actionTerms; } else { return null; } } @Override public void processMovement(String agName, Capability capability) { Action act = capability.getAction(); Term origin = act.getTerm(0); Term destination = act.getTerm(1); Predicate new_position = new Predicate("at"); Predicate old_position = new Predicate("at");  if (checkAction(act) != null) { Pair newTerms = checkAction(act); old_position.addTerm(origin); removePercept(old_position); addPercept((Predicate) newTerms._2);} else { new_position.addTerm(destination); old_position.addTerm(origin); removePercept(old_position); addPercept(new_position); } } }