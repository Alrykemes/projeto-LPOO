package com.managepro.core.service;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.managepro.exceptions.ExcecaoDoSistema;

public class GeradorQrCodePix {

	public static BufferedImage obterQrCodePix(BigDecimal valor) throws ExcecaoDoSistema{
        try {
        	
        	String valorString = String.format("%.2f", valor).replaceAll(",", ".");
        	
        	int tamanhoTransacao = valorString.length();
        	
            String codigoPix = "00020126330014br.gov.bcb.pix011115607265471520400005303986"
            		+ "540" + tamanhoTransacao 
            		+ valorString 
            		+ "5802BR5925Alrykemes Gomes Cavalcant6009Sao Paulo62230519ManageProServicosSA6304";
            
            codigoPix += calcularCRC16(codigoPix);
            
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(codigoPix, BarcodeFormat.QR_CODE, 350, 350);

            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, new MatrixToImageConfig());

            return qrImage;
        } catch (Exception ex) {
        	throw new ExcecaoDoSistema("Erro ao gerar QrCode do Pix, Tente novamente mais tarde!", ex);
        }
    }
	
	private static String calcularCRC16(String str) {
        int polinomio = 0x1021;
        int resultado = 0xFFFF;

        for (int i = 0; i < str.length(); i++) {
            resultado ^= (str.charAt(i) << 8);
            for (int j = 0; j < 8; j++) {
                if ((resultado & 0x8000) != 0) {
                    resultado = (resultado << 1) ^ polinomio;
                } else {
                    resultado = (resultado << 1);
                }
            }
        }
        return String.format("%04X", resultado & 0xFFFF);
    }
}