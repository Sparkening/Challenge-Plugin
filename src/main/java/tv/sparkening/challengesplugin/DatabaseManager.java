package tv.sparkening.challengesplugin;

import com.google.gson.Gson;

import java.io.File;
import java.sql.*;

public class DatabaseManager {

    public DatabaseManager(ChallengesPlugin plugin) {

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        String url = "JDBC:sqlite:" + plugin.getDataFolder().getAbsolutePath() + "/challenges.db";

        initializeDatabase();
    }

    // save states using SQLite
    private void initializeDatabase() {
        String createChallengeTable = "CREATE TABLE IF NOT EXISTS global_state ("
                + "id INTEGER PRIMARY KEY, "
                + "json_data TEXT);";
    }

    //saves challenge info using gson - banger shit
    public void saveGlobalState(ChallengeState stateToSave) {
        Gson gson = new Gson();
        String jsonText = gson.toJson(stateToSave);

        String sql = "INSERT OR REPLACE INTO global_state (id, json_data) VALUES (1, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, jsonText);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }

    public ChallengeState loadGlobalState() {
        String sql = "SELECT json_data FROM global_state WHERE id = 1";

        // ... try/catch block to connect to the database and run the query ...

        // Let's pretend we successfully grabbed the text and saved it here:
        String jsonText = "the text from the database";

        Gson gson = new Gson();

        // Now we need to unpack it!
    }
}