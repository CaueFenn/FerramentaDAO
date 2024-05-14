/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Ferramenta;

public class FerramentaDAOimpl implements FerramentaDAO{
    private Map<Integer, Ferramenta> ferramentas,
    
    public FerramentaDAOimpl() {
        this.Ferramentas = new HashMap<>();
    }
    
    @Override
    public void salvarFerramenta(Ferramenta ferramenta){
     ferramentas.put(ferramentas.getId(), ferramenta);
 }
 
 
    @Override
    public void atualizarFerramenta(Ferramenta ferramenta){
     ferramentas.put(ferramentas.getId(), ferramenta);
}
     
    @Override
    public void excluirFerramenta(int id){
        ferramentas.remove(id);
    }
    
    @Override
    public Ferramenta buscarFerramentaPorId(int id){
        return ferramentas.get(id);
    }
    
    @Override 
    public List<Ferramenta> listarTodasFerramentas(){
        return new ArrayList<> (ferramentas.values());

            
}
}