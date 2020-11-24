import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.web.bind.annotation.*;


@RestController
public class Upc{

	@RequestMapping(value = "/UPC/{u}", method = RequestMethod.GET)
	public String index(@PathVariable(value = "u", required = true) String upc,
						@RequestParam(value = "dr", defaultValue = "1") int dateRange,
						@RequestParam(value = "si", defaultValue = "1", 
										required = true) String storeId){

		final int UPC_LENGTH = 12;
		final int STORE_LENGTH = 4;
		String result = "";

		if (upc.length() <= UPC_LENGTH
			& dateRange > 0 
			& dateRange < 365
			& storeId.length() <= STORE_LENGTH) {

			try{
				int parsedUpc = Integer.parseInt(upc);
				int parsedStore = Integer.parseInt(storeId);
			}catch(NumberFormatException e){
				e.printStackTrace();
				throw new CustomException();
			}
			long epochNow = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
			long epochStart = epochNow - (dateRange * 8640); 
			result = getDbResult(upc, epochStart, storeId);
		}
		return result;
	}
}