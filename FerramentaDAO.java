/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.List;
import model.Ferramenta;

public interface FerramentaDAO {
    void salvarFerramenta(Ferramenta ferramenta);
    void atualizarFerramenta(Ferramenta ferramenta);
    void excluirFerramenta(int id);
    List <Ferramenta> 
    listarTodasFerramentas();
}
