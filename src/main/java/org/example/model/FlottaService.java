package org.example.model;


import org.example.persistenza.Database;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FlottaService {

    public static List<Utente> utenti = new List<Utente>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Utente> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Utente utente) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Utente> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Utente> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Utente get(int index) {
            return null;
        }

        @Override
        public Utente set(int index, Utente element) {
            return null;
        }

        @Override
        public void add(int index, Utente element) {

        }

        @Override
        public Utente remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Utente> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Utente> listIterator(int index) {
            return null;
        }

        @Override
        public List<Utente> subList(int fromIndex, int toIndex) {
            return List.of();
        }
    };
    public static List<Veicolo> veicoli = new List<Veicolo>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Veicolo> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Veicolo veicolo) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Veicolo> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Veicolo> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Veicolo get(int index) {
            return null;
        }

        @Override
        public Veicolo set(int index, Veicolo element) {
            return null;
        }

        @Override
        public void add(int index, Veicolo element) {

        }

        @Override
        public Veicolo remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Veicolo> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Veicolo> listIterator(int index) {
            return null;
        }

        @Override
        public List<Veicolo> subList(int fromIndex, int toIndex) {
            return List.of();
        }
    };
    
    public static void registraVeicolo(Veicolo v) throws Exception {
        if (v == null) {
            throw new Exception("Veicolo non valido");
        }
        veicoli.add(v);
        Database db = Database.GetIstance();
        // scrivere correttamente Integer numeroMarce = v is Bici ? v.getNumeroMarce() else null; con operatore ternario
        Integer numeroMarce = (v instanceof Bici) ? ((Bici) v).getNumeroMarce() : null;
        Double velMax = (v instanceof Monopattino) ? ((Monopattino) v).getVelocitaMax() : null;
        Double battPerMin = (v instanceof Monopattino) ? ((Monopattino) v).getBattPerMin() : null;
        Boolean limitatoInZonaPedonale = (v instanceof Monopattino) ? ((Monopattino) v).isLimitatoInZonaPedonale() : null;

        db.insertVeicolo(v.getLivelloBatteria(), v.getStato().toString(), v.getTariffa(),numeroMarce, velMax, battPerMin, limitatoInZonaPedonale);
    }

    public static void registraUtente(Utente u) throws Exception {
        if (u == null) {
            throw new Exception("Utente non valido");
        }
        utenti.add(u);
        Database db = Database.GetIstance();
        db.insertUtente(u.getNome(), u., u.getEmail(), u.getCf(), u.getCredito());
    }

    public static void sbloccaVeicolo(String codice, String idUtente) throws Exception {
        // logica per sbloccare il veicolo
    }

    public static void terminaNoleggio(String codice, int minutiUsati) throws Exception {
        // logica per terminare il noleggio
    }

    public static void mettiInRicarica(String codice) throws Exception {
        // logica per mettere il veicolo in ricarica
    }


}
