# Ideas 

## module CORE
Board imp should be injected with a PiecePool which provides instances of 'aggregate' Piece. Piece contains a Validator for moves and somehow it should also generate moves.
It is not really a pool, more of a Provider which generates instances as needed for each game when started.

...maybe instead, semplifying things with a facade while letting objs communicate through a mediator:


b1 c3

Board.getDetails(b1) returns PieceID piece //not including long opponentSquares because thats concern of 
CaptureValidator which checks if a same color piece is being captured. No more PlacementDetails { PieceID pieceOn, long occupiedSquares }

ValidatorProvider.movementValidator(pieceOn)

//MoveResult = moveValidator.validate(toBitboard(b1), occupiedSquares) instead it is cleaner:
MoveResult = movementValidator.validate(b1, c3) then the moveValidator on its own communicates with the Board to retrieve occupiedSquares, mediator pattern(?). 
This way no need to return PlacementDetails, just PieceID. Moreover bitboard implementation is hidden inside the mediator.

...moveResult logic<br>
if valid
checkValidator.validate(b1, c3)
if capture 
captureValidator.validate(b1, c3) //still talks with Board through mediator

...doesn't work because a validator should be indipendent from inner objs state. It cannot communicate through a mediator but it has to accept Board instance as argument
.validate(b1, c3, Board)

### Inside validator



















