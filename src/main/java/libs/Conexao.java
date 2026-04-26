package libs;

import model.entities.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

    public static final String url = "jdbc:mysql://localhost:3306/HOTEL";
    public static final String user = "root";
    public static final String password = "K007k@2006";

    public static void salvarReserva(Reservation reservation) {

        String sql = "INSERT INTO informacoes_cadastro(numero, checkIn, checkOut) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement st = connection.prepareStatement(sql);
        ) {
            st.setInt(1, reservation.getNumber());
            st.setDate(2, new java.sql.Date(reservation.getCheckIn().getTime()));
            st.setDate(3, new java.sql.Date(reservation.getCheckOut().getTime()));
            st.executeUpdate();
            System.out.println("Reserva salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        }
    }
}
