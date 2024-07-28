package gwendolen.failuredetection.hallway.syntheticexamples._19;import ail.syntax.*;import ail.semantics.AILAgent;import ail.util.Tuple;import ajpf.util.AJPFLogger;import gwendolen.failuredetection.environments.ReconfigurationHallwayEnvironment;import gov.nasa.jpf.util.Pair;import java.util.Dictionary;import java.util.Hashtable;public class _19 extends ReconfigurationHallwayEnvironment {Hashtable<Pair, Pair> failingactions = new Hashtable<>();Pair<String, String> actionTerms;Pair<Term, Term> a;Pair<Term, Term> b;static String logname = "gwendolen.failuredetection._19";public _19() {super();a = new Pair<>(at3, at5);b = new Pair<>(at3, at3);failingactions.put(a,b);a = new Pair<>(at5, at2);b = new Pair<>(at5, at6);failingactions.put(a,b);a = new Pair<>(at5, at3);b = new Pair<>(at5, at5);failingactions.put(a,b);a = new Pair<>(at1, at5);b = new Pair<>(at1, at6);failingactions.put(a,b);a = new Pair<>(at1, at4);b = new Pair<>(at1, at1);failingactions.put(a,b);a = new Pair<>(at2, at5);b = new Pair<>(at2, at1);failingactions.put(a,b);a = new Pair<>(at5, at6);b = new Pair<>(at5, at2);failingactions.put(a,b);a = new Pair<>(at6, at5);b = new Pair<>(at6, at3);failingactions.put(a,b);}public Pair checkAction(Action act) { Literal from = new Literal("at"); from.addTerm(act.getTerm(0)); Literal to = new Literal("at"); to.addTerm(act.getTerm(1)); Pair<Term, Term> actionTerms = new Pair<>(from, to); if (failingactions.containsKey(actionTerms)) { actionTerms = failingactions.get(actionTerms); /* action terms are now the failing action terms */ return actionTerms; } else { return null; } } public void init_after_adding_agents(){ for (AILAgent a: agentmap.values()){a.setCapabilityLibrary(capLibrary);a.setCapabilityLibrary(capLibrary);addPercept(at1); } } @Override public void processMovement(String agName, Capability capability) { Action act = capability.getAction(); Term origin = act.getTerm(0); Term destination = act.getTerm(1); Predicate new_position = new Predicate("at"); Predicate old_position = new Predicate("at");  if (checkAction(act) != null) { Pair newTerms = checkAction(act); old_position.addTerm(origin); removePercept(old_position); addPercept((Predicate) newTerms._2);} else { new_position.addTerm(destination); old_position.addTerm(origin); removePercept(old_position); addPercept(new_position); } } }