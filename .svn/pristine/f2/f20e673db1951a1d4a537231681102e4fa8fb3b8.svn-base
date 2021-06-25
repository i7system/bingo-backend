
package br.com.bingo.controllers;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class Rascunho {

   //
   //	@RequestMapping(value = "properties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
   // UIProperty getProperties() {
   //       return uiProperty;
   //   }
	
	
	@PostMapping(path = "/recebendoxmlteste", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String recebendoxml(@RequestBody Object notafiscal) throws ParserConfigurationException, SAXException  {
	
		String texto= "";
		try {
            File file = new File("c:/teste.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();

            String emit_CNPJ="";
            String emit_xNome="";   
            String emit_xFant="";  
            String emit_IE="";
            String emit_CRT="";         
            
            String enderEmit_xLgr="";
            String enderEmit_nro="";
            String enderEmit_xCpl="";
            String enderEmit_xBairro="";
            String enderEmit_cMun="";
            String enderEmit_xMun="";
            String enderEmit_UF="";
            String enderEmit_CEP="";
            String enderEmit_cPais="";
            String enderEmit_xPais="";
            String enderEmit_fone="";
            
            String dest_CNPJ="";
            String dest_xNome="";   
            String dest_IE="";
            String dest_indIEDest="";      
            String dest_email="";      
            
            String enderDest_xLgr="";
            String enderDest_nro="";
            String enderDest_xCpl="";
            String enderDest_xBairro="";
            String enderDest_cMun="";
            String enderDest_xMun="";
            String enderDest_UF="";
            String enderDest_CEP="";
            String enderDest_cPais="";
            String enderDest_xPais="";
            String enderDest_fone="";
                      
            String nfeProc_xmlns ="";
            String nfeProc_versao ="";           
            String NFe_xmlns="";
            String infNFe_Id="";
            String infNFe_versao="";
            
            String ide_cUF = "";
            String ide_cNF ="";
            String ide_natOp = "";
            String ide_mod = "";
            String ide_serie ="";
            String ide_nNF="";
            String ide_dhEmi="";
            String ide_dhSaiEnt="";
            String ide_tpNF ="";
            String ide_idDest = "";
            String ide_cMunFG ="";
            String ide_tpImp="";
            String ide_tpEmis="";
            String ide_cDV="";
            String ide_tpAmb="";
            String ide_finNFe="";
            String ide_indFinal="";
            String ide_indPres="";
            String ide_procEmi="";
            String ide_verProc = "";
            
            String total = "";
            String ICMSTot = "";
            String ICMSTot_vBC = "";
            String ICMSTot_vICMS = "";
            String ICMSTot_vICMSDeson = "";
            String ICMSTot_vFCPUFDest = "";
            String ICMSTot_vICMSUFDest = "";
            String ICMSTot_vICMSUFRemet = "";
            String ICMSTot_vFCP = "";
            String ICMSTot_vBCST = "";
            String ICMSTot_vST = "";
            String ICMSTot_vFCPST = "";
            String ICMSTot_vFCPSTRet = "";
            String ICMSTot_vProd = "";
            String ICMSTot_vFrete = "";
            String ICMSTot_vSeg = "";
            String ICMSTot_vDesc = "";
            String ICMSTot_vII = "";
            String ICMSTot_vIPI = "";
            String ICMSTot_vIPIDevol = "";
            String ICMSTot_vPIS = "";
            String ICMSTot_vCOFINS = "";
            String ICMSTot_vOutro = "";
            String ICMSTot_vNF = "";           
            
            
            String transp ="";
            String transp_modFrete="";
            
            String transporta = "";
            String transporta_CNPJ = "";
            String transporta_xNome = "";
            String transporta_IE = "";
            String transporta_xEnder = "";
            String transporta_xMun = "";
            String transporta_UF = "";
            String vol = "";
            String vol_esp = "";
            
            String fat = "";
            String fat_nFat = "";
            String fat_vOrig = "";
            String fat_vDesc = "";
            String fat_vLiq = "";
            String dup = "";
            String dup_nDup = "";
            String dup_dVenc = "";
            String dup_vDup ="";
            
            String detPag = "";
            String detPag_indPag = "";
            String detPag_tPag = "";
            String detPag_vPag = "";
            
            String infAdic = "";
            String infAdic_infAdFisco = "";
            String infAdic_infCpl = "";
            
            String infRespTec ="";
            String infRespTec_CNPJ ="";
            String infRespTec_xContato ="";
            String infRespTec_email ="";
            String infRespTec_fone ="";
            
            String Signature = "";
            String Signature_xmlns = "";
            String Signature_SignatureValue = "";
            
            String Signature_SignedInfo = "";
            String SignedInfo_xmlns = "";
            String CanonicalizationMethod_Algorithm = "";
            String SignatureMethod_Algorithm = "";
            String SignedInfo_CanonicalizationMethod = "";
            String SignedInfo_SignatureMethod = "";
            
            
            String Reference_URI = "";           
            String Reference_DigestValue = "";
            String Transform_Algorithm  = "";
            String DigestMethod_Algorithm = "";
            String X509Certificate = "";
            
            String protNFe_xmlns = "";
            String protNFe_versao = "";
            
            String infProt_tpAmb = "";
            String infProt_verAplic = "";
            String infProt_chNFe = "";
            String infProt_dhRecbto = "";
            String infProt_nProt = "";
            String infProt_digVal = "";
            String infProt_cStat = "";
            String infProt_xMotivo= "";
            
            // pegando campos do nfeProc
            NodeList nList1 = document.getElementsByTagName("nfeProc");
            for (int temp = 0; temp < nList1.getLength(); temp++) {
                Node nNode = nList1.item(temp);           
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    nfeProc_xmlns=eElement.getAttribute("xmlns");
                    nfeProc_versao=eElement.getAttribute("versao");        
                    
                    texto = "<nfeProc xmlns='" +nfeProc_xmlns+ "' versao='"+nfeProc_versao+"'>" + "\n";
                    
                   }
            }
            
            // pegando campos do NFe
            NodeList nList2 = document.getElementsByTagName("NFe");
            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);           
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    NFe_xmlns=eElement.getAttribute("xmlns");
                    
                    texto = texto+  "<NFe xmlns='" +NFe_xmlns+"'>" + "\n";
                   
                }
            }
            
            // pegando campos do infNFe versao
            NodeList nList3 = document.getElementsByTagName("infNFe");
            for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node nNode = nList3.item(temp);           
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    infNFe_Id=eElement.getAttribute("Id");
                    infNFe_versao=eElement.getAttribute("versao");
                    
                    texto = texto + "<infNFe Id='" +infNFe_Id+ "' versao='"+infNFe_versao+"'>" + "\n";
                    
                }
            }
            
            // pegando campos do IDE
            NodeList nList4 = document.getElementsByTagName("ide");
            for (int temp = 0; temp < nList4.getLength(); temp++) {
                Node nNode = nList4.item(temp);           
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    ide_cUF=eElement.getElementsByTagName("cUF").item(0).getTextContent();
                    ide_cNF=eElement.getElementsByTagName("cNF").item(0).getTextContent();
                    ide_natOp=eElement.getElementsByTagName("natOp").item(0).getTextContent();
                    ide_mod=eElement.getElementsByTagName("mod").item(0).getTextContent();
                    ide_serie=eElement.getElementsByTagName("serie").item(0).getTextContent();
                    ide_nNF=eElement.getElementsByTagName("nNF").item(0).getTextContent();
                    ide_dhEmi=eElement.getElementsByTagName("dhEmi").item(0).getTextContent();
                    ide_dhSaiEnt=eElement.getElementsByTagName("dhSaiEnt").item(0).getTextContent();
                    ide_tpNF=eElement.getElementsByTagName("tpNF").item(0).getTextContent();
                    ide_idDest=eElement.getElementsByTagName("idDest").item(0).getTextContent();
                    ide_cMunFG=eElement.getElementsByTagName("cMunFG").item(0).getTextContent();
                    ide_tpImp=eElement.getElementsByTagName("tpImp").item(0).getTextContent();
                    ide_tpEmis=eElement.getElementsByTagName("tpEmis").item(0).getTextContent();
                    ide_cDV=eElement.getElementsByTagName("cDV").item(0).getTextContent();
                    ide_tpAmb=eElement.getElementsByTagName("tpAmb").item(0).getTextContent();
                    ide_finNFe=eElement.getElementsByTagName("finNFe").item(0).getTextContent();
                    ide_indFinal=eElement.getElementsByTagName("indFinal").item(0).getTextContent();
                    ide_indPres=eElement.getElementsByTagName("indPres").item(0).getTextContent();
                    ide_procEmi=eElement.getElementsByTagName("procEmi").item(0).getTextContent();
                    ide_verProc=eElement.getElementsByTagName("verProc").item(0).getTextContent();
                    
                }
            }
  
            // pegando campos do emit
            NodeList nList5 = document.getElementsByTagName("emit");
            for (int temp = 0; temp < nList5.getLength(); temp++) {
                Node nNode = nList5.item(temp);           
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    emit_CNPJ=eElement.getElementsByTagName("CNPJ").item(0).getTextContent();
                    emit_xNome=eElement.getElementsByTagName("xNome").item(0).getTextContent();
                    emit_xFant=eElement.getElementsByTagName("xFant").item(0).getTextContent();           
                    emit_IE=eElement.getElementsByTagName("IE").item(0).getTextContent();
                    emit_CRT=eElement.getElementsByTagName("CRT").item(0).getTextContent();
                }
            }




   
          
            
         
        }
        catch(IOException e) {
            System.out.println(e);
        } 
    System.out.println(texto);
		  return texto;

		
		
	}
}
