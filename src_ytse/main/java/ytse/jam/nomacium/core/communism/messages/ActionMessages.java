//package ytse.jam.nomacium.core.communism.messages;
//
//
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.DistExecutor;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class ActionMessages {
//
//
//
//	public static class CApplyRecoil {
//		public float xRot;
//		public float yRot;
//
//		public CApplyRecoil() {}
//
//		public CApplyRecoil(float xRot, float yRot) {
//			this.xRot = xRot;
//			this.yRot = yRot;
//		}
//
//		public static void encode(CApplyRecoil msg, FriendlyByteBuf buf) {
//			buf.writeFloat(msg.xRot);
//			buf.writeFloat(msg.yRot);
//		}
//
//		public static CApplyRecoil decode(FriendlyByteBuf buf) {
//			return new CApplyRecoil(buf.readFloat(), buf.readFloat());
//		}
//
//		public static void handle(CApplyRecoil msg, Supplier<NetworkEvent.Context> contextSupplier) {
//			NetworkEvent.Context context = contextSupplier.get();
//			context.enqueueWork(() -> {
//				DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> FirearmActionCHandlers.handleCApplyRecoil(msg, contextSupplier));
//			});
//			context.setPacketHandled(true);
//		}
//	}
//
//
//}
