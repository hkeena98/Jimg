/**
 *@author Henry Keena
 *@version  
 *@license MIT 
 */

//Imports From Java Main Library
import java.io.*;
import java.util.*;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Imports From JavaX Library
import javax.imageio.*;
import javax.imageio.stream.*;
import javax.imageio.metadata.*;

//Imports From JavaFX Library
import javafx.application.*;
import javafx.application.Application;
import javafx.beans.*;
import javafx.beans.value.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.geometry.*;
import javafx.util.*;

//Imports From Apache Commons
import org.apache.commons.io.FileUtils;

 
/**
 * Start of Jimg Image Analyzer
 */
public class Jimg extends Application
{
    //Declares Stage and Scene
	private Stage stage;
	private Scene scene;
	
	//Declares VBox
	private VBox root = new VBox(8);
	
	//Declares GridPanes
    private GridPane grid = new GridPane();

    //Declares MenuBar
	private MenuBar menuBar = new MenuBar();

	//Declares Menu 
	private Menu menuOpt = new Menu("Options");

	//Declares MenuItems For Options Menu
    private MenuItem menFiles = new MenuItem("Open Image");
    private MenuItem menExit = new MenuItem("Exit");

    
    //Declares Recent List of Images
    private ArrayList<Image> recentImages = new ArrayList<Image>();
    
    //Declares Image
    private Image currImage;

    //Declares ImageView
    private ImageView iv1 = new ImageView();

    public String fetchImageFile()
    {
        try
        {
            FileChooser fileCh = new FileChooser();
            fileCh.setTitle("Open Image Files");
            fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG Files (*.jpg)", "*.jpg"));
            fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Files (*.jpeg)", "*.jpeg"));
            fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files (*.png)", "*.png"));
            fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("GIF Files (*.gif)", "*.gif"));
            fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("BMP Files (*.bmp)", "*.bmp"));
            File selFile = fileCh.showOpenDialog(stage);
            if(selFile == null)
            {
                return null;
            }
            File fileDest = new File("assets/img/");
            FileUtils.copyFileToDirectory(selFile, fileDest);
            File finFile = new File(fileDest+selFile.getName());
            System.out.println(finFile.getAbsolutePath());
            return finFile.getAbsolutePath();
        }
        catch(Exception ex)
        {
            System.out.println("Exception Error Caught: "+ex);
        }
        return null;
    }

    public void displayImage(String img)
    {
        iv1.setImage(null);
        currImage = new Image(getClass().getResourceAsStream(img));
        iv1.setImage(currImage);
    }

    public void readBytes()
    {

    }

    public void getMetaData()
    {

    }

    public void analyzeImage()
    {

    }

    public void saveTOJSON()
    {

    }

    public void exit()
	{
		System.exit(0);
	}

    public void start(Stage _stage) throws Exception
	{
        stage = _stage;
        stage.setTitle("Jimg Image Analyzer");
        
        int width = 1000;
        int height = 800;

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.add(iv1, 0, 1);


        menuBar.getMenus().addAll(menuOpt);

        menuOpt.getItems().addAll(menFiles, menExit);



        //Menu Handler
		menFiles.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent evt)
			{
                String img = fetchImageFile();
				displayImage(img);
			}
        });

        //Menu Handler
		menExit.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent evt)
			{
				exit();
			}
		});
        
        root.getChildren().addAll(menuBar, grid);

        scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.show();
    }

    public static void main(String[] args)
	{
		launch(args);
   	}
}