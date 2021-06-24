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

...the solution may be going functional with pipelines.

### pipeline steps

Where do I validate special moves like en passant and castling? 
1. Inside validMovement : moveEvaluator also placed inside SMELLS BAD
2. on its own pipeline step : requires special moveEvaluator(quiet move or capture) per piece. THIS SEEMS BETTER!!!

each piece has its own moveEvaluator, a generic one for most pieces (a capture is recognized whether a piece occupies the target square) or special for pawns and king

```Java
class Piece {
	movementValidator(Move, Position) returns boolean
	moveCategorizator(Move, Position) returns CategorizedMove
	moveExecutor(CategorizedMove, Position) returns Position //returns a new position without altering current 
}

class Move {
	Square from
	Square to
}

class CategorizedMove extends Move{
	MoveType type { Quiet, Capture, EnPassant, Castling }
}
```
How do I retrieve the instance of Piece containing moveValidator and moveEvaluator??? (and moveExecutor may require the same treatment)

.require(validMovement) 
.require(noCheckAfter)
.require(validMove)
.onValid(moveExecutor) //different types of execution for special moves (castling moves 2 pieces, en-passant has the captured piece on a different square)
.onFail(() -> false)

### undo moves

Hold previous positions not only single moves. NOT SURE



















