package BookMyShow.BookMyShowBackend.Controller;

import BookMyShow.BookMyShowBackend.Dto.SeatDto;
import BookMyShow.BookMyShowBackend.Entity.Seat;
import BookMyShow.BookMyShowBackend.Service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seat/")
@CrossOrigin(origins = "http://localhost:4200")
public class SeatController {

    private final SeatService seatService;

    @PostMapping("addseat")
    public ResponseEntity<Seat> addSeat(@RequestBody SeatDto seatDto){
        return ResponseEntity.status(HttpStatus.OK).body(seatService.addSeat(seatDto));
    }

    @GetMapping("allseats/{theatreName}/{movieName}/{locationName}")
    public ResponseEntity<List<Seat>> getAllseats(@PathVariable String theatreName,@PathVariable String movieName,@PathVariable String locationName){
        return ResponseEntity.status(HttpStatus.OK).body(seatService.getAllBymovieName(theatreName,movieName,locationName));
    }
    @PutMapping("updateseat")
    public ResponseEntity<Seat> updateseat(@RequestBody Seat seat){
        return ResponseEntity.status(HttpStatus.OK).body(seatService.updateseat(seat));
    }
}
