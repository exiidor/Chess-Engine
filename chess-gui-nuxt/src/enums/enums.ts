export enum PacketType {
	LoginC2S = "LoginC2S",
	LoginResultS2C = "LoginResultS2C",
	UserListS2C = "UserListS2C",
	GamesS2C = "GamesS2C",
	KickS2C = "KickS2C",
	CreateGameC2S = "CreateGameC2S",
	CreateGameResultS2C = "CreateGameResultS2C",
	InviteS2C = "InviteS2C",
	InviteResponseC2S = "InviteResponseC2S",
	UserJoinedS2C = "UserJoinedS2C",
	JoinGameS2C = "JoinGameS2C",
	GameS2C = "GameS2C",
	BoardS2C = "BoardS2C",
	LeaveGameC2S = "LeaveGameC2S",
	UserLeftS2C = "UserLeftS2C",
	RequestMovesC2S = "RequestMovesC2S",
	MovesS2C = "MovesS2C",
	MoveC2S = "MoveC2S",
	MoveS2C = "MoveS2C",
	SpectateGameC2S = "SpectateGameC2S",
	GameEndedS2C = "GameEndedS2C",
}

export enum UserStatus {
	Online = "ONLINE",
	Playing = "PLAYING",
	Spectating = "SPECTATING",
	Offline = "OFFLINE"
}

export enum PieceType {
	Pawn = "Pawn",
	Rook = "Rook",
	Knight = "Knight",
	Bishop = "Bishop",
	Queen = "Queen",
	King = "King"
}

export enum MoveType {
	Normal = "NormalMove",
	Capture = "CaptureMove",
	Promotion = "PromotionMove",
	EnPassant = "EnPassantMove",
	Castling = "CastlingMove"
}

export enum PieceColor {
	White = "WHITE",
	Black = "BLACK"
}

export enum SquareState {
	Default,
	Selected,
	Highlighted,
	HighlightedCapture,
	HighlightedPromotion
}
